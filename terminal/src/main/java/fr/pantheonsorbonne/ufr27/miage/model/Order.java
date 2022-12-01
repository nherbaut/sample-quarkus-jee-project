package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @Column(name = "order_id", nullable = false)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name="productOrder",
            joinColumns=@JoinColumn(name="Product_ID", referencedColumnName="order_id"),
            inverseJoinColumns=@JoinColumn(name="Order_ID", referencedColumnName="product_id"))
    private List<Product> orderContent = new ArrayList<>();

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

    public List<Product> getProducts() {
        return orderContent;
    }

    public void setProducts(List<Product> products) {
        this.orderContent = products;
    }

    public Order(Integer id, List<Product> orderContent, LocalDate orderDate, Float orderPrice, Client client, Employee employee) {
        this.id = id;
        this.orderContent = orderContent;
        this.orderDate = orderDate;
        this.orderPrice = orderPrice;
        this.client = client;
        this.employee = employee;
    }
}