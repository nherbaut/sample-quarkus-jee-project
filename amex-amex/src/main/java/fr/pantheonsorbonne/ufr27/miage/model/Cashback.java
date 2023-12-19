package fr.pantheonsorbonne.ufr27.miage.model;
import jakarta.persistence.*;

@Entity
public class Cashback {

    private Integer idClient;

    private Integer idTransaction;

    private float tauxCashback;
}
