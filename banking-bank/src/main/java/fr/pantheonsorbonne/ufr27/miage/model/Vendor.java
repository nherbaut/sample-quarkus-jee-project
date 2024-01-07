package fr.pantheonsorbonne.ufr27.miage.model;

import jakarta.persistence.*;

@NamedQueries({@NamedQuery(name = "getQuotasForVendor", query = "SELECT q from VenueQuota q where q.id.vendor=?1")})
@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVendor", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    public Vendor(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Vendor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}