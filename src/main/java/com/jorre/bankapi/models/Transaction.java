package com.jorre.bankapi.models;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;
    private Long registeredTime;
    private Long executedTime;
    private Double cashAmount;
    @OneToOne
    private Account sourceAccount;
    @OneToOne
    private Account destinationAccount;

    public Transaction() {
    }

    public Transaction(Long registeredTime, Long executedTime, Double cashAmount, Account sourceAccount,
                       Account destinationAccount) {
        this.registeredTime = registeredTime;
        this.executedTime = executedTime;
        this.cashAmount = cashAmount;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(Long registeredTime) {
        this.registeredTime = registeredTime;
    }

    public Long getExecutedTime() {
        return executedTime;
    }

    public void setExecutedTime(Long executedTime) {
        this.executedTime = executedTime;
    }

    public Double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", registeredTime=" + registeredTime +
                ", executedTime=" + executedTime +
                ", cashAmount=" + cashAmount +
                ", sourceAccount=" + sourceAccount.getId() +
                ", destinationAccount=" + destinationAccount.getId() +
                '}';
    }

}
