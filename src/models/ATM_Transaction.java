package models;

import dao.Shared;

import java.util.Date;

public class ATM_Transaction {
    private String transactionId;
    private Date transDate;
    private TransactionType type;
    private double amount;
    private Account sourceAcc;
    private Account destinationAcc;

    public ATM_Transaction() {
    }

    public ATM_Transaction(String transactionId, Date transDate, TransactionType type, double amount, Account sourceAcc, Account destinationAcc) {
        this.transactionId = transactionId;
        this.transDate = transDate;
        this.type = type;
        this.amount = amount;
        this.sourceAcc = sourceAcc;
        this.destinationAcc = destinationAcc;
    }

    public ATM_Transaction(String transactionId, Date transDate, TransactionType type, double amount, Account sourceAcc) {
        this.transactionId = transactionId;
        this.transDate = transDate;
        this.type = type;
        this.amount = amount;
        this.sourceAcc = sourceAcc;
    }

    public String getTransactionId() {
        return transactionId;
    }


    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getSourceAcc() {
        return sourceAcc;
    }

    public void setSourceAcc(Account sourceAcc) {
        this.sourceAcc = sourceAcc;
    }

    public Account getDestinationAcc() {
        return destinationAcc;
    }

    public void setDestinationAcc(Account destinationAcc) {
        this.destinationAcc = destinationAcc;
    }

    public boolean update() {
        boolean mode = sourceAcc.getManagedBy().getIdBank() == Shared.getCurrentATM().getManagedBy().getIdBank();
        double tariff = mode ? 0 : 6;
        if (type == TransactionType.WITHDRAWAL) {
            return sourceAcc.withdraw(amount, tariff);
        } else {
            if (sourceAcc.withdraw(amount, tariff)) {
                destinationAcc.deposit(amount);
                return true;
            }
            return false;
        }
    }
}
