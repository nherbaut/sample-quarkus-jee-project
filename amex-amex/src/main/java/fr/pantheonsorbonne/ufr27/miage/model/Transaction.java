package fr.pantheonsorbonne.ufr27.miage.model;
import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTransaction", nullable = false)
    private Integer idTransaction;

    @JoinColumn(name = "idClient")
    private Integer idClient;

    private double montantTransaction;

    private boolean transactionStatue;


    public Transaction(Integer idClient, double montantTransaction){
        this.idClient=idClient;
        this.montantTransaction=montantTransaction;
        this.transactionStatue=false;
    }

    public Transaction(){}

    public void setTransactionStatue(boolean transactionStatue) {this.transactionStatue = transactionStatue;}

    public boolean isTransactionStatue() {return transactionStatue;}

    public Integer getIdClient() {return idClient;}

    public void setIdClient(Integer idClient) {this.idClient = idClient;}

    public Integer getIdTransaction() {return idTransaction;}

    public void setIdTransaction(Integer idTransaction) {this.idTransaction = idTransaction;}

    public double getMontantTransaction() {return montantTransaction;}

    public void setMontantTransaction(double montantTransaction) {this.montantTransaction = montantTransaction;}
}
