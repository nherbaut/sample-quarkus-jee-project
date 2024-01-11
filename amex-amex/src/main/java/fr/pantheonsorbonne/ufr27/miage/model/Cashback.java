package fr.pantheonsorbonne.ufr27.miage.model;
import jakarta.persistence.*;

@Entity
public class Cashback {

    @Id
    @Column(name = "idCashback", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCashback;

    @JoinColumn(name = "idClient")
    private Integer idClient;

    @JoinColumn(name = "idTransaction")
    private Integer idTransaction;

    private float tauxCashback;

    public Cashback(Integer idClient, Integer idTransaction, float tauxCashback){
        this.idClient=idClient;
        this.idTransaction=idTransaction;
        this.tauxCashback=tauxCashback;
    }

    public Cashback() {}

    public Integer getIdClient() {return idClient;}

    public void setIdClient(Integer idClient) {this.idClient = idClient;}

    public Integer getIdCashback() {return idCashback;}

    public void setIdCashback(Integer idCashback) {this.idCashback = idCashback;}

    public float getTauxCashback() {return tauxCashback;}

    public void setTauxCashback(float tauxCashback) {this.tauxCashback = tauxCashback;}

    public Integer getIdTransaction() {return idTransaction;}

    public void setIdTransaction(Integer idTransaction) {this.idTransaction = idTransaction;}
}
