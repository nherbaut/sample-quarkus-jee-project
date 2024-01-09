package fr.pantheonsorbonne.ufr27.miage.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class BankAccount {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_account", nullable = false)
    private int idAccount;
    @Basic
    @Column(name = "id_customer", nullable = false)
    private int idCustomer;
    @Basic
    @Column(name = "id_transaction", nullable = false)
    private int idTransaction;
    @Basic
    @Column(name = "solde", nullable = true, precision = 2)
    private BigDecimal solde;

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount account = (BankAccount) o;
        return idAccount == account.idAccount && idCustomer == account.idCustomer && idTransaction == account.idTransaction && Objects.equals(solde, account.solde);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccount, idCustomer, idTransaction, solde);
    }
}
