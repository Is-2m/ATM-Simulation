package models;

public class ATM {
    private int idATM;
    private Bank managedBy;

    public ATM() {
    }

    public ATM(int idATM, Bank managedBy) {
        this.idATM = idATM;
        this.managedBy = managedBy;
    }

    public int getIdATM() {
        return idATM;
    }

    public void setIdATM(int idATM) {
        this.idATM = idATM;
    }

    public Bank getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(Bank managedBy) {
        this.managedBy = managedBy;
    }

    public void printTransactions() {
    }
}
