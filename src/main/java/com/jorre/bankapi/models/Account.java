package com.jorre.bankapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

    @GeneratedValue
    @Id
    private long id;
    private String name;
    private double availableCash;

    public Account() {
    }

    public Account(String name, double availableCash) {
        this.name = name;
        this.availableCash = availableCash;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvailableCash() {
        return availableCash;
    }

    public void setAvailableCash(double availableCash) {
        this.availableCash = availableCash;
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
