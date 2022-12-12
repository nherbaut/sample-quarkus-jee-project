package fr.pantheonsorbonne.ufr27.miage.dto;

import java.util.Collection;
import java.util.Date;

public class OrderDTO {

    Integer orderId;

    Date localDate;

    Float orderPrice;

    Integer employeeId;

    Integer clientId;

    double totalPrice;

    Collection<ProductDTO> productDTO;

    public OrderDTO(Integer orderId, Date localDate, Float orderPrice, Integer employeeId, Integer clientId, double totalPrice, Collection<ProductDTO> productDTO) {
        this.orderId = orderId;
        this.localDate = localDate;
        this.orderPrice = orderPrice;
        this.employeeId = employeeId;
        this.clientId = clientId;
        this.totalPrice = totalPrice;
        this.productDTO = productDTO;
    }

    Collection<OrderItemDTO> productDTO;

    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Collection<OrderItemDTO> getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(Collection<OrderItemDTO> productDTO) {
        this.productDTO = productDTO;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", localDate=" + localDate +
                ", orderPrice=" + orderPrice +
                ", employeeId=" + employeeId +
                ", clientId=" + clientId +
                ", productDTO=" + productDTO +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
