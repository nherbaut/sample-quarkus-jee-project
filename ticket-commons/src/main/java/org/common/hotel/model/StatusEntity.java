package org.common.hotel.model;

import jakarta.persistence.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "status_generator")
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public StatusEntity() {
    }

    public StatusEntity(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        StatusEntity that = (StatusEntity) object;
        return id == that.id && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }
}
