package models;

import dao.Shared;

import java.util.Date;

public class ATM_Transaction {
    private String transactionId;
    private Date transDate;
    private TransactionType type;
    private double amount;
    private DebitCard sourceCard;
    private DebitCard destinationCard;

    public ATM_Transaction() {
    }

    public ATM_Transaction(String transactionId, Date transDate, TransactionType type, double amount, DebitCard sourceCard, DebitCard destinationCard) {
        this.transactionId = transactionId;
        this.transDate = transDate;
        this.type = type;
        this.amount = amount;
        this.sourceCard = sourceCard;
        this.destinationCard = destinationCard;
    }

    public ATM_Transaction(String transactionId, Date transDate, TransactionType type, double amount, DebitCard sourceCard) {
        this.transactionId = transactionId;
        this.transDate = transDate;
        this.type = type;
        this.amount = amount;
        this.sourceCard = sourceCard;
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

    public DebitCard getSourceCard() {
        return sourceCard;
    }

    public void setSourceCard(DebitCard sourceCard) {
        this.sourceCard = sourceCard;
    }

    public DebitCard getDestinationCard() {
        return destinationCard;
    }

    public void setDestinationCard(DebitCard destinationCard) {
        this.destinationCard = destinationCard;
    }

    public boolean update() {
        boolean mode = sourceCard.providesAccessTo().getManagedBy().getIdBank() == Shared.getCurrentATM().getManagedBy().getIdBank();
        double tariff = mode ? 0 : 6;
        if (type == TransactionType.WITHDRAWAL) {
            return sourceCard.providesAccessTo().withdraw(amount, tariff);
        } else {
            if (sourceCard.providesAccessTo().withdraw(amount, tariff)) {
                destinationCard.providesAccessTo().deposit(amount);
                return true;
            }
            return false;
        }
    }
}
