package fr.pantheonsorbonne.ufr27.miage.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_customer", nullable = false)
    private int idCustomer;
    @Basic
    @Column(name = "firstName", nullable = false, length = 30)
    private String firstName;
    @Basic
    @Column(name = "lastName", nullable = false, length = 30)
    private String lastName;
    @Basic
    @Column(name = "adress", nullable = false, length = 50)
    private String adress;
    @Basic
    @Column(name = "email", nullable = false, length = 50)

    private String email;
    public Customer(String firstName,String lastName, String adress, String email){

        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.email = email;
    }
    public Customer(){}
    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return idCustomer == customer.idCustomer && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(adress, customer.adress) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCustomer, firstName, lastName, adress, email);
    }
}
