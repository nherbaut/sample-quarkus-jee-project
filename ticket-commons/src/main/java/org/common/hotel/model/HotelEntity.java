package org.common.hotel.model;

import jakarta.persistence.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "hotel_generator")
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        HotelEntity that = (HotelEntity) object;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
