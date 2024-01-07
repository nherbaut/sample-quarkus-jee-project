package top.nextnet.model;

import java.math.BigDecimal;
import java.util.Objects;


import javax.persistence.*;

@Entity
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_account")
    private int idAccount;
    @Basic
    @Column(name = "id_customer")
    private int idCustomer;
    @Basic
    @Column(name = "id_transaction")
    private int idTransaction;
    @Basic
    @Column(name = "solde")
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
        Account account = (Account) o;
        return idAccount == account.idAccount && idCustomer == account.idCustomer && idTransaction == account.idTransaction && Objects.equals(solde, account.solde);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccount, idCustomer, idTransaction, solde);
    }
}
