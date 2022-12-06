package fr.pantheonsorbonne.ufr27.miage.dto;

public class ProductDTO {
    String id_product;
    double unitaryPrice;
    String name;

    public ProductDTO() {
    }

    public ProductDTO(String id_product) {
        this.id_product = id_product;
    }

    public ProductDTO(double unitaryPrice, String id, String name) {
        this.unitaryPrice = unitaryPrice;
        this.id_product = id;
        this.name = name;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(double unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id_product='" + id_product + '\'' +
                ", unitaryPrice=" + unitaryPrice +
                ", name='" + name + '\'' +
                '}';
    }
}