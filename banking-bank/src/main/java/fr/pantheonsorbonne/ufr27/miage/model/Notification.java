package fr.pantheonsorbonne.ufr27.miage.model;

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
    @Column(name = "texte", nullable = false, length = 255)
    private String texte;
    @Basic
    @Column(name = "etat", nullable = false)
    private byte etat;
    @Basic
    @Column(name = "id_account", nullable = false)
    private int idAccount;
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "type", nullable = false, length = 50)
    private String type;
    public Notification(String texte, byte etat, int idAccount, Date date, String type){
        this.texte = texte;
        this.etat = etat;
        this.idAccount = idAccount;
        this.date = date;
        this.type = type;
    }
    public Notification(){
    }
    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return idNotification == that.idNotification && etat == that.etat && idAccount == that.idAccount && Objects.equals(texte, that.texte) && Objects.equals(date, that.date) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNotification, texte, etat, idAccount, date, type);
    }
}
