package fr.pantheonsorbonne.ufr27.miage.dto;

public class OrderItemDTO {
    Integer id_item;
    double unitaryPrice;
    String name;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Integer id_item) {
        this.id_item = id_item;
    }

    public OrderItemDTO(double unitaryPrice, Integer id, String name) {
        this.unitaryPrice = unitaryPrice;
        this.id_item = id;
        this.name = name;

    }

    public Integer getId_item() {
        return id_item;
    }

    public void setId_item(Integer id_item) {
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