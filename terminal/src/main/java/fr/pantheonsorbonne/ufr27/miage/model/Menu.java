package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id", nullable = false)
    private Integer id;

    @Size(max = 60)
    @NotNull
    @Column(name = "menu_name", nullable = false, length = 60)
    private String menuName;

    @NotNull
    @Column(name = "menu_price", nullable = false)
    private Float menuPrice;

    @ManyToMany
    @JoinTable(
            name="productMenu",
            joinColumns=@JoinColumn(name= "Menu_ID", referencedColumnName="menu_id"),
            inverseJoinColumns=@JoinColumn(name= "Product_ID", referencedColumnName="product_id"))
    private List<Product> menuContent = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Float getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(Float menuPrice) {
        this.menuPrice = menuPrice;
    }

    public List<Product> getMenuContent() {
       return menuContent;
    }

    public void setMenuContent(List<Product> menuContent) {
        this.menuContent = menuContent;
    }

}