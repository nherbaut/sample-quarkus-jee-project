package fr.pantheonsorbonne.ufr27.miage.model;
import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTransaction", nullable = false)
    private Integer idTransaction;

    private Integer idClient;

    private float montantTransaction;
}
