package com.jorre.bankapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * JPA entity reflecting the Account model in the db. Contains basic information
 * about a bank account.
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    private Double availableCash;

    public Account() {
    }

    public Account(String name, Double availableCash) {
        this.name = name;
        this.availableCash = availableCash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAvailableCash() {
        return availableCash;
    }

    private void setAvailableCash(Double amount) {
        this.availableCash = amount;
    }

    /**
     * Convenience method for adding funds to this entity's cashAmount.
     * @param amount amount to be added
     */
    public void addCash(double amount) {
        setAvailableCash(getAvailableCash() + amount);
    }

    /**
     * Subtracts the specified amount from this entity's cashAmount.
     * Throws IllegalStateException if the account has insufficient funds.
     * @param amount amount to subtract
     */
    public void subtractCash(double amount) {
        if (getAvailableCash() < amount) {
            throw new IllegalStateException("Not enough available cash to make withdrawal");
        }
        setAvailableCash(getAvailableCash() - amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", availableCash=" + availableCash +
                '}';
    }

}
