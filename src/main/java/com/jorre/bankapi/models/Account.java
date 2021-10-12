package com.jorre.bankapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

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
     * Convenience method for adding funds to this entity's cashAmount. Uses
     * BigDecimal to avoid rounding errors.
     *
     * @param amount amount to be added
     */
    public void addCash(double amount) {
        setAvailableCash(BigDecimal.valueOf(getAvailableCash())
                .add(BigDecimal.valueOf(amount))
                .doubleValue());
    }

    /**
     * Subtracts the specified amount from this entity's cashAmount. Uses
     * BigDecimal to avoid rounding errors. Throws IllegalStateException if the
     * account has insufficient funds.
     *
     * @param amount amount to subtract
     */
    public void subtractCash(double amount) {
        if (getAvailableCash() < amount) {
            throw new IllegalStateException("Insufficient funds");
        }
        setAvailableCash(BigDecimal.valueOf(getAvailableCash())
                .subtract(BigDecimal.valueOf(amount))
                .doubleValue());
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
