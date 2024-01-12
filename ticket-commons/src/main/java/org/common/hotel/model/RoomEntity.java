package org.common.hotel.model;

import jakarta.persistence.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
@Entity

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class RoomEntity {
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "room_generator")
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "nbr_bed")
    private Integer nbrBed;

    @Column(name = "price")
    private Double price;

    @Column(name = "reservation_id")
    private Integer reservationId;

    @Column(name = "hotel_id")
    private Long hotelId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNbrBed() {
        return nbrBed;
    }

    public void setNbrBed(Integer nbrBed) {
        this.nbrBed = nbrBed;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        RoomEntity that = (RoomEntity) object;
        return id == that.id && Objects.equals(nbrBed, that.nbrBed) && Objects.equals(price, that.price) && Objects.equals(reservationId, that.reservationId) && Objects.equals(hotelId, that.hotelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nbrBed, price, reservationId, hotelId);
    }
}
