package fr.pantheonsorbonne.ufr27.miage.model;
import jakarta.persistence.*;

@Entity
public class Cashback {

    @Id
    @Column(name = "idCashback", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCashback;

    private Integer idClient;

    private double montant;

    private double taux;

    private double montantCashback;

    public Cashback(Integer idClient, double taux, double montant){
        this.idClient=idClient;
        this.montantCashback=montant*(taux/100);
        this.taux=taux;
        this.montant=montant;
    }

    public Cashback() {}

    public Integer getIdClient() {return idClient;}

    public void setIdClient(Integer idClient) {this.idClient = idClient;}

    public Integer getIdCashback() {return idCashback;}

    public void setIdCashback(Integer idCashback) {this.idCashback = idCashback;}

    public double getTaux() {return taux;}

    public void setTaux(double taux) {this.taux = taux;}

    public double getMontantCashback() {return montantCashback;}

    public void setMontantCashback(double montantCashback) {this.montantCashback = montantCashback;}

    public double getMontant() {return montant;}

    public void setMontant(double montant) {this.montant = montant;}
}

