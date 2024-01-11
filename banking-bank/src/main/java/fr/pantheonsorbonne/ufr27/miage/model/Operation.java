package fr.pantheonsorbonne.ufr27.miage.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Operation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_operation", nullable = false)
    private int idOperation;
    @Basic
    @Column(name = "id_account", nullable = false)
    private int idAccount;
    @Basic
    @Column(name = "id_transaction", nullable = false)
    private int idTransaction;

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return idOperation == operation.idOperation && idAccount == operation.idAccount && idTransaction == operation.idTransaction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOperation, idAccount, idTransaction);
    }
}
