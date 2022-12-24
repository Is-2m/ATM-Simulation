package models;

import java.util.ArrayList;

public class Account {
    private long accountNum;
    private double balance;
    private Customer owner;
    private Bank managedBy;


    public Account() {
    }

    public Account(long accountNum, double balance, Customer owner, Bank managedBy) {
        this.accountNum = accountNum;
        this.balance = balance;
        this.owner = owner;
        this.managedBy = managedBy;
    }


    public long getAccountNum() {
        return accountNum;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public double checkBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Bank getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(Bank managedBy) {
        this.managedBy = managedBy;
    }

    public boolean withdraw(double Amount,double tariff) {
        if (balance >= Amount) {
            balance -= (Amount+tariff);
            return true;
        } else {
            return false;
        }
    }

    public void deposit(double Amount) {
        balance += Amount;
    }
}
