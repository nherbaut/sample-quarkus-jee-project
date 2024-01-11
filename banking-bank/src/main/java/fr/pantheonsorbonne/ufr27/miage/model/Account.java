package fr.pantheonsorbonne.ufr27.miage.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_account", nullable = false)
    private int idAccount;
    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic
    @Column(name = "solde", nullable = false, precision = 0)
    private double solde;
    @Basic
    @Column(name = "id_customer", nullable = false)
    private int idCustomer;

    public Account(String password, double solde, int idCustomer){
        this.password = password;
        this.solde = solde;
        this.idCustomer = idCustomer;
    }

    public Account() {

    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return idAccount == account.idAccount && solde == account.solde && idCustomer == account.idCustomer && Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccount, password, solde, idCustomer);
    }
}
