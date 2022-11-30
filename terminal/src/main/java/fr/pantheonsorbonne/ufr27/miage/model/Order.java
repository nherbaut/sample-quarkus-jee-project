package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @Column(name = "order_id", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    @NotNull
    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @NotNull
    @Column(name = "order_price", nullable = false)
    private Float orderPrice;

    public Float getOrderPrice() {
        return orderPrice;
    }
    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Size(max = 1073741824)
    @NotNull
    @Column(name = "order_content", nullable = false, length = 1073741824)
    private String orderContent;

    public String getOrderContent() {
        return orderContent;
    }
    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    /*
    private Collection<Product> Product;
    @ManyToMany(mappedBy = "id.product_id")
    public Collection<Product> getProduct() {
        return Product;
    }
    public void setProduct(Collection<Product> product) {
        this.Product = Product;
    }*/
}
