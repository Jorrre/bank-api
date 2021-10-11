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

@RestController
@RequestMapping(path = "api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> performTransaction(@RequestBody TransactionForm form) {
        return ResponseEntity.ok(transactionService.performTransaction(
                form.getSourceAccountName(),
                form.getDestinationAccountName(),
                form.getAmount()));
    }
}
