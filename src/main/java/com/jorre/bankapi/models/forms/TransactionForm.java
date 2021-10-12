package com.jorre.bankapi.models.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * POJO reflecting the RequestBody of a POST request to /api/transactions.
 */
public class TransactionForm {

    @NotBlank
    private String sourceAccountName;
    @NotBlank
    private String destinationAccountName;
    @NotNull
    private Double amount;

    public TransactionForm() {
    }

    public String getSourceAccountName() {
        return sourceAccountName;
    }

    public void setSourceAccountName(String sourceAccountName) {
        this.sourceAccountName = sourceAccountName;
    }

    public String getDestinationAccountName() {
        return destinationAccountName;
    }

    public void setDestinationAccountName(String destinationAccountName) {
        this.destinationAccountName = destinationAccountName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
