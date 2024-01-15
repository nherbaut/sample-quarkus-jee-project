package com.hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nbr_bed")
    private Integer nbrBed;

    @Column(name = "price")
    private Double price;

    @Column(name = "is_available")
    private Boolean isAvailable;



    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Room that = (Room) object;
        return Objects.equals(id, that.id) && Objects.equals(nbrBed, that.nbrBed) && Objects.equals(price, that.price) && Objects.equals(isAvailable, ((Room) object).isAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nbrBed, price,isAvailable);
    }
}
