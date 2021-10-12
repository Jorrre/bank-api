package com.jorre.bankapi.controllers;

import com.jorre.bankapi.models.Transaction;
import com.jorre.bankapi.models.forms.TransactionForm;
import com.jorre.bankapi.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling requests related to transactions.
 * Includes handler method for handling a transaction from one Account to another.
 */
@RestController
@RequestMapping(path = "api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Handles a transaction between two Accounts.
     * @param form user input from the request body, including source account,
     *             destination account and amount.
     * @return the successful Transaction object if the transaction is valid
     * with status code 200, or status code 400 if an invalid Account is
     * submitted or if the source account has insufficient funds.
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> performTransaction(@RequestBody TransactionForm form) {
        return ResponseEntity.ok(transactionService.performTransaction(
                form.getSourceAccountName(),
                form.getDestinationAccountName(),
                form.getAmount()));
    }
}
