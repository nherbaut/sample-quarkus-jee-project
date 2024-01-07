package fr.pantheonsorbonne.ufr27.miage.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Transaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_transaction", nullable = false)
    private int idTransaction;
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "montant", nullable = false, precision = 0)
    private double montant;
    @Basic
    @Column(name = "destinataire", nullable = false, length = 50)
    private String destinataire;
    @Basic
    @Column(name = "etat", nullable = false)
    private byte etat;
    @Basic
    @Column(name = "type", nullable = false, length = 20)
    private String type;

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public byte getEtat() {
        return etat;
    }

    public void setEtat(byte etat) {
        this.etat = etat;
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
        Transaction that = (Transaction) o;
        return idTransaction == that.idTransaction && Double.compare(that.montant, montant) == 0 && etat == that.etat && Objects.equals(date, that.date) && Objects.equals(destinataire, that.destinataire) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransaction, date, montant, destinataire, etat, type);
    }
}
