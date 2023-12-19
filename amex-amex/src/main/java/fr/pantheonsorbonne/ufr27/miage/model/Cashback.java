package fr.pantheonsorbonne.ufr27.miage.model;
import jakarta.persistence.*;

@Entity
public class Cashback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCashback", nullable = false)
    private Integer idCashback;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client idClient;

    @ManyToOne
    @JoinColumn(name = "idTransaction")
    private Transaction idTransaction;

    private float tauxCashback;

    public Cashback(Client idClient, Transaction idTransaction, float tauxCashback){
        this.idClient=idClient;
        this.idTransaction=idTransaction;
        this.tauxCashback=tauxCashback;
    }

    public Client getIdClient() {return idClient;}

    public void setIdClient(Client idClient) {this.idClient = idClient;}

    public Integer getIdCashback() {return idCashback;}

    public void setIdCashback(Integer idCashback) {this.idCashback = idCashback;}

    public float getTauxCashback() {return tauxCashback;}

    public void setTauxCashback(float tauxCashback) {this.tauxCashback = tauxCashback;}

    public Transaction getIdTransaction() {return idTransaction;}

    public void setIdTransaction(Transaction idTransaction) {this.idTransaction = idTransaction;}
}
