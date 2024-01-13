package fr.pantheonsorbonne.ufr27.miage.model;

import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTicket", nullable = false)
    private int idTicket;

    @JoinColumn(name = "idClient")
    private int idClient;

    @Column(name = "montantTransaction", nullable = false)
    private float montant;

    public Ticket(int idTicket, int idClient, float montant) {
        this.idTicket = idTicket;
        this.idClient = idClient;
        this.montant = montant;
    }

    public Ticket() {

    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

}