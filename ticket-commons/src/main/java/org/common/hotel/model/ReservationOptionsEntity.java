package org.common.hotel.model;

import jakarta.persistence.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ReservationOptionsEntity {
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "reservation_option_generator")
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "price")
    private Integer price;
    @Basic
    @Column(name = "reservation_id")
    private Integer reservationId;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ReservationOptionsEntity that = (ReservationOptionsEntity) object;
        return id == that.id && Objects.equals(price, that.price) && Objects.equals(reservationId, that.reservationId) && Objects.equals(description, that.description) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, reservationId, description, name);
    }
}
