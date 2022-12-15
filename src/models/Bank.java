package models;

import java.util.ArrayList;

public class Bank {
    private int idBank;
    private String bankName;
    private ArrayList<Account> accounts;

    public Bank() {
    }


    public Bank(int idBank, String bankName) {
        this.idBank = idBank;
        this.bankName = bankName;
    }

    public Bank(int idBank, String bankName, ArrayList<Account> accounts) {
        this.idBank = idBank;
        this.bankName = bankName;
        this.accounts = accounts;
    }

    public int getIdBank() {
        return idBank;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
}
