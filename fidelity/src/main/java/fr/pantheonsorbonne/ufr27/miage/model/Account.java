package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Integer id;

    @Column(name = "total_points")
    private Integer totalPoints;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private fr.pantheonsorbonne.ufr27.miage.model.Client client;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public fr.pantheonsorbonne.ufr27.miage.model.Client getClient() {
        return client;
    }

    public void setClient(fr.pantheonsorbonne.ufr27.miage.model.Client client) {
        this.client = client;
    }

}