package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Menu")
public class Menu extends OrderItem{

    /*
    @ManyToMany
    @JoinTable(
            name="productMenu",
            joinColumns=@JoinColumn(name= "Menu_ID", referencedColumnName="menu_id"),
            inverseJoinColumns=@JoinColumn(name= "Product_ID", referencedColumnName="product_id"))
    private List<Product> menuContent = new ArrayList<>();
    */
}