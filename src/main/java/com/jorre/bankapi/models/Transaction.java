package com.jorre.bankapi.models;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue()
    private long id;
    private long registeredTime;
    private long executedTime;
    private boolean success;
    private double cashAmount;
    @OneToOne
    private Account sourceAccount;
    @OneToOne
    private Account destinationAccount;

    public Transaction() {
    }

    public Transaction(long registeredTime, long executedTime, boolean success, double cashAmount,
                       Account sourceAccount, Account destinationAccount) {
        this.registeredTime = registeredTime;
        this.executedTime = executedTime;
        this.success = success;
        this.cashAmount = cashAmount;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(long registeredTime) {
        this.registeredTime = registeredTime;
    }

    public long getExecutedTime() {
        return executedTime;
    }

    public void setExecutedTime(long executedTime) {
        this.executedTime = executedTime;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(double cashAmount) {
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
                ", success=" + success +
                ", cashAmount=" + cashAmount +
                ", sourceAccount=" + sourceAccount +
                ", destinationAccount=" + destinationAccount +
                '}';
    }

}
