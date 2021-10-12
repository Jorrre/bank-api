package com.jorre.bankapi.services;

import com.jorre.bankapi.models.Account;
import com.jorre.bankapi.models.Transaction;
import com.jorre.bankapi.repositories.AccountRepository;
import com.jorre.bankapi.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;

/**
 * Service methods for transaction related operations
 */
@Service
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(AccountRepository accountRepository,
                              TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    /**
     * Performs a transaction by fetching the relevant accounts from the db,
     * creating a transaction object reflecting the transaction properties and
     * stores this and the updated accounts in the db. Annotated with
     * transactional to maintain ensure database integrity.
     * <p>
     * Throws a 400 status code exception if the data is invalid
     *
     * @param sourceAccountName      account to transfer from
     * @param destinationAccountName account to transfer to
     * @param amount                 how much to be transferred
     * @return the Transaction object reflecting this transactions
     */
    @Transactional
    public Transaction performTransaction(String sourceAccountName,
                                          String destinationAccountName,
                                          double amount) {
        if (amount <= 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Amount must be greater than zero");
        Transaction transaction = new Transaction();
        transaction.setCashAmount(amount);
        transaction.setRegisteredTime(Instant.now().toEpochMilli());
        try {
            Account sourceAccount =
                    accountRepository.findByName(sourceAccountName).orElseThrow(EntityNotFoundException::new);
            Account destinationAccount =
                    accountRepository.findByName(destinationAccountName).orElseThrow(EntityNotFoundException::new);
            if (sourceAccount.equals(destinationAccount))
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Cannot have the same account as source and " +
                                "destination");

            transaction.setSourceAccount(sourceAccount);
            transaction.setDestinationAccount(destinationAccount);

            destinationAccount.addCash(amount);
            sourceAccount.subtractCash(amount);

            accountRepository.save(sourceAccount);
            accountRepository.save(destinationAccount);

            transaction.setExecutedTime(Instant.now().toEpochMilli());

            return transactionRepository.save(transaction);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "At least one of the accounts doesn't exist");
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }

    }

}
