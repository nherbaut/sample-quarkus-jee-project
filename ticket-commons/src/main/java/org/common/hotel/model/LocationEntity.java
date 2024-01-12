package org.common.hotel.model;

import jakarta.persistence.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class LocationEntity {
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "location_generator")
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "zip_code")
    private int zipCode;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "hotel_id")
    private long hotelId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LocationEntity that = (LocationEntity) object;
        return id == that.id && zipCode == that.zipCode && hotelId == that.hotelId && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, city, zipCode, country, hotelId);
    }
}
