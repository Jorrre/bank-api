package com.jorre.bankapi.controllers.requestBodies;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * POJO reflecting the RequestBody of the transaction handler method in
 * TransferController
 */
public class TransactionRequestBody {

    @NotBlank
    private String sourceAccountName;
    @NotBlank
    private String destinationAccountName;
    @NotNull
    private Double amount;

    public TransactionRequestBody() {
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
