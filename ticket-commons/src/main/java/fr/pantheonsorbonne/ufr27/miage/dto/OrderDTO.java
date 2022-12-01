package fr.pantheonsorbonne.ufr27.miage.dto;

import java.time.LocalDate;
import java.util.Collection;

public class OrderDTO {

    String orderId;

    LocalDate localDate;

    Float orderPrice;

    Integer employeeId;

    Integer clientId;

    public OrderDTO(String orderId, LocalDate localDate, Float orderPrice, Integer employeeId, Integer clientId, double totalPrice) {
        this.orderId = orderId;
        this.localDate = localDate;
        this.orderPrice = orderPrice;
        this.employeeId = employeeId;
        this.clientId = clientId;
        this.totalPrice = totalPrice;
    }

    Collection<ProductDTO> productDTO;

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

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
}
