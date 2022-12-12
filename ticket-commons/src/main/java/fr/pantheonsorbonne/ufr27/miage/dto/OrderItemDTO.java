package fr.pantheonsorbonne.ufr27.miage.dto;

public class OrderItemDTO {
    String id_item;
    double unitaryPrice;
    String name;

    public OrderItemDTO() {
    }

    public OrderItemDTO(String id_item) {
        this.id_item = id_item;
    }

    public OrderItemDTO(double unitaryPrice, String id, String name) {
        this.unitaryPrice = unitaryPrice;
        this.id_item = id;
        this.name = name;

    }

    public String getId_item() {
        return id_item;
    }

    public void setId_item(String id_item) {
        this.id_item = id_item;
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
        return "OrderItemDTO{" +
                "id_item='" + id_item + '\'' +
                ", unitaryPrice=" + unitaryPrice +
                ", name='" + name + '\'' +
                "} \n";
    }
}