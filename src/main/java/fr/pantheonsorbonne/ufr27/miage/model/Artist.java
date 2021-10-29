package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    @OneToMany
    @JoinTable(name = "Tour_for_artist")
    private Collection<Venue> venues;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
