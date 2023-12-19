package fr.pantheonsorbonne.ufr27.miage.model;
import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTransaction", nullable = false)
    private Integer idTransaction;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client idClient;

    private float montantTransaction;

    public Transaction(Client idClient, float montantTransaction){
        this.idClient=idClient;
        this.montantTransaction=montantTransaction;
    }

    public Client getIdClient() {return idClient;}

    public void setIdClient(Client idClient) {this.idClient = idClient;}

    public Integer getIdTransaction() {return idTransaction;}

    public void setIdTransaction(Integer idTransaction) {this.idTransaction = idTransaction;}

    public float getMontantTransaction() {return montantTransaction;}

    public void setMontantTransaction(float montantTransaction) {this.montantTransaction = montantTransaction;}
}
