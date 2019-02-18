package com.epam.jpa.simple.models;

import javax.persistence.*;

@Entity
public class Customer extends Person
{
    private double balance;

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }
}
