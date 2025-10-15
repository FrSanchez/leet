package com.splabs.meta.banking;

public class Account {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int updateBalance(int amount) {
        this.balance += amount;
        return this.balance;
    }

    private String accountId;

    public String getAccountId() {
        return accountId;
    }
    public Account(String accountId) {
        this.accountId = accountId;
        this.balance = 0;
    }
}
