package fr.pantheonsorbonne.ufr27.miage.dto;

import java.time.LocalDate;
import java.util.Collection;

public class OrderDTOContainer {

    String orderId;

    Collection<ProductDTO> productDTO;

    Float TotalPrice;

    LocalDate localDate;

    double totalPrice;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Collection<ProductDTO> getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(Collection<ProductDTO> productDTO) {
        this.productDTO = productDTO;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        TotalPrice = totalPrice;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "OrderDTOContainer{" +
                "orderId='" + orderId + '\'' +
                ", productDTO=" + productDTO +
                ", TotalPrice=" + TotalPrice +
                ", localDate=" + localDate +
                ", totalPrice=" + totalPrice +
                '}';
    }


}
