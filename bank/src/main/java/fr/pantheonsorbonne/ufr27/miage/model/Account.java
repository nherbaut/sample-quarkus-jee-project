package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "customer_name", nullable = false, length = 50)
    private String customerName;

    @NotNull
    @Column(name = "max_decouvert", nullable = false)
    private Float maxDecouvert;

    @NotNull
    @Column(name = "plafond", nullable = false)
    private Float plafond;

    @NotNull
    @Column(name = "solde", nullable = false)
    private Float solde;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Float getMaxDecouvert() {
        return maxDecouvert;
    }

    public void setMaxDecouvert(Float maxDecouvert) {
        this.maxDecouvert = maxDecouvert;
    }

    public Float getPlafond() {
        return plafond;
    }

    public void setPlafond(Float plafond) {
        this.plafond = plafond;
    }

    public Float getSolde() {
        return solde;
    }

    public void setSolde(Float solde) {
        this.solde = solde;
    }

}