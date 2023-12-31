package fr.pantheonsorbonne.ufr27.miage.dto;

public class ConfirmationPayment {

    int idTransaction;
    boolean transactionStatus;

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public boolean isTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(boolean transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
