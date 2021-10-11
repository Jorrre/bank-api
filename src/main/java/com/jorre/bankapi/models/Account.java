package com.jorre.bankapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double availableCash;

    public Account() {
    }

    public Account(Long id, String name, Double availableCash) {
        this.id = id;
        this.name = name;
        this.availableCash = availableCash;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getAvailableCash() {
        return availableCash;
    }

    private void setAvailableCash(Double amount) {
        this.availableCash = amount;
    }

    public void addCash(double amount) {
        setAvailableCash(getAvailableCash() + amount);
    }

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
