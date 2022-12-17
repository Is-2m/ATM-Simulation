package models;

import java.util.ArrayList;

public class Bank {
    private long idBank;
    private String bankName;

    public Bank() {
    }


    public Bank(long idBank, String bankName) {
        this.idBank = idBank;
        this.bankName = bankName;
    }


    public long getIdBank() {
        return idBank;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

}
