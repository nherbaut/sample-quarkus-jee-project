package fr.pantheonsorbonne.ufr27.miage.model;

import jakarta.persistence.*;

@Entity
public class CashBack {

    @Id
    @JoinColumn(name = "idTransaction")
    private Integer idTransaction;

    @JoinColumn(name = "idClient")
    private Integer idClient;

    @Column(name = "tauxCashback", nullable = false)
    private float tauxCashback;

    public CashBack(Integer idClient, Integer idTransaction, float tauxCashback){
        this.idClient=idClient;
        this.idTransaction=idTransaction;
        this.tauxCashback=tauxCashback;
    }

    public CashBack() {}

    public Integer getIdClient() {return idClient;}

    public void setIdClient(Integer idClient) {this.idClient = idClient;}

    public float getTauxCashback() {return tauxCashback;}

    public void setTauxCashback(float tauxCashback) {this.tauxCashback = tauxCashback;}

    public Integer getIdTransaction() {return idTransaction;}

    public void setIdTransaction(Integer idTransaction) {this.idTransaction = idTransaction;}
}
