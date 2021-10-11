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

@Service
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public Transaction performTransaction(String sourceAccountName, String destinationAccountName, double amount) {
        Transaction transaction = new Transaction();
        transaction.setCashAmount(amount);
        transaction.setRegisteredTime(Instant.now().toEpochMilli());
        try {
            Account sourceAccount = accountRepository.findByName(sourceAccountName).orElseThrow(EntityNotFoundException::new);
            Account destinationAccount = accountRepository.findByName(destinationAccountName).orElseThrow(EntityNotFoundException::new);
            transaction.setSourceAccount(sourceAccount);
            transaction.setDestinationAccount(destinationAccount);
            destinationAccount.addCash(amount);
            sourceAccount.subtractCash(amount);
            accountRepository.save(sourceAccount);
            accountRepository.save(destinationAccount);
            transaction.setExecutedTime(Instant.now().toEpochMilli());
            return transactionRepository.save(transaction);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "At least one of the accounts doesn't exist");
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Source account does not have sufficient cash");
        }

    }

}
