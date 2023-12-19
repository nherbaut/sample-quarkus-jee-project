package fr.pantheonsorbonne.ufr27.miage.model;
import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient", nullable = false)
    private Integer idClient;

    private Integer num_carte;

    private enum genre {HOMME,FEMME,NONBINAIRE,AUTRE};

    private Integer age;

    private String profession;


}
