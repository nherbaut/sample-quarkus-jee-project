package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "product_name", nullable = false, length = 50)
    private String productName;

    @NotNull
    @Column(name = "product_price", nullable = false)
    private Float productPrice;

    @Size(max = 20)
    @NotNull
    @Column(name = "product_type", nullable = false, length = 20)
    private String productType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

}