package models;

import java.util.UUID;

public class Account {
    private String accountId;
    private UUID ownerId;
    private double balance;
    private boolean active;

    public Account(UUID ownerId) {
        this.accountId = generateAccountId();
        this.ownerId = ownerId;
        this.balance = 0.0;
        this.active = true;
    }

    private String generateAccountId() {
        String randomPart = UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        int numberPart = (int)(Math.random() * 9000) + 1000;
        return "BK-" + randomPart + "-" + numberPart;
    }

    public String getAccountId() {
        return accountId;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean closeAccount() {
        if (balance == 0 && active) {
            active = false;
            return true;
        }
        return false;
    }
}

