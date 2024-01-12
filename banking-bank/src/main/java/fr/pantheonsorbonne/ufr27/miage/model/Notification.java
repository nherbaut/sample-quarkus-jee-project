package fr.pantheonsorbonne.ufr27.miage;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Notification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_notification", nullable = false)
    private int idNotification;
    @Basic
    @Column(name = "id_typeNotification", nullable = false)
    private int idTypeNotification;
    @Basic
    @Column(name = "etat", nullable = false)
    private byte etat;
    @Basic
    @Column(name = "id_account", nullable = false)
    private int idAccount;
    @Basic
    @Column(name = "date", nullable = true)
    private Date date;

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public int getIdTypeNotification() {
        return idTypeNotification;
    }

    public void setIdTypeNotification(int idTypeNotification) {
        this.idTypeNotification = idTypeNotification;
    }

    public byte getEtat() {
        return etat;
    }

    public void setEtat(byte etat) {
        this.etat = etat;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return idNotification == that.idNotification && idTypeNotification == that.idTypeNotification && etat == that.etat && idAccount == that.idAccount && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNotification, idTypeNotification, etat, idAccount, date);
    }
}
