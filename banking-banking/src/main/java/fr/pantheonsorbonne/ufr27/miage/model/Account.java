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
    @Column(name = "id_bank", nullable = false)
    private int idBank;
    @Basic
    @Column(name = "id_user", nullable = false)
    private int idUser;

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getIdBank() {
        return idBank;
    }

    public void setIdBank(int idBank) {
        this.idBank = idBank;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return idAccount == account.idAccount && idBank == account.idBank && idUser == account.idUser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccount, idBank, idUser);
    }
}
