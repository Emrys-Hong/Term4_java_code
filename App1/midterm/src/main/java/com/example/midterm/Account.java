package com.example.midterm;

import java.util.Comparator;
import java.util.Date;

public class Account implements Comparable<Account> {
    private  String id;
    private double balance;
    private Date dataCreated;

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    @Override
    public int compareTo(Account account) {
        if (balance > account.balance) {
            return 1;
        } else if (balance == account.getBalance()) {
            return 0;
        } else {
            return -1;
        }
    }

    public double getBalance() {
        return balance;
    }

    public Date getDataCreated() {
        return dataCreated;
    }

    @Override
    public String toString() {
        return "Account:" + this.id;
    }


}
