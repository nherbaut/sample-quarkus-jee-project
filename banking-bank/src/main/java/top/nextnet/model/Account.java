package top.nextnet.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Account {
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
}
