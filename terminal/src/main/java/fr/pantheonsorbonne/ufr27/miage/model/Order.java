package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @Column(name = "order_id", nullable = false)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name="orderContent",
            joinColumns=@JoinColumn(name= "Order_ID", referencedColumnName="order_id"),
            inverseJoinColumns=@JoinColumn(name= "Item_ID", referencedColumnName="item_id"))
    private List<OrderItem> orderContent = new ArrayList<>();


    @NotNull
    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @NotNull
    @Column(name = "order_price", nullable = false)
    private Float orderPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public Order() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<OrderItem> getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(List<OrderItem> OrderItems) {
        this.orderContent = OrderItems;
    }

    public Order(Integer id, List<OrderItem> orderContent, LocalDate orderDate, Float orderPrice, Client client, Employee employee) {
        this.id = id;
        this.orderContent = orderContent;
        this.orderDate = orderDate;
        this.orderPrice = orderPrice;
        this.client = client;
        this.employee = employee;
    }

}