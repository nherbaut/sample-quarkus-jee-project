package org.common.hotel.model;

import jakarta.persistence.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;
import java.util.Objects;

@XmlRootElement
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ReservationEntity {
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "reservation_generator")
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nbr_guest")
    private Integer nbrGuest;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "room_id")
    private Integer roomId;

    @Basic
    @Column(name = "start_date")
    private Timestamp startDate;
    @Basic
    @Column(name = "end_date")
    private Timestamp endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNbrGuest() {
        return nbrGuest;
    }

    public void setNbrGuest(Integer nbrGuest) {
        this.nbrGuest = nbrGuest;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }
    public ReservationEntity() {
        // Default constructor
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ReservationEntity that = (ReservationEntity) object;
        return id == that.id && Objects.equals(nbrGuest, that.nbrGuest) && Objects.equals(userId, that.userId) && Objects.equals(roomId, that.roomId) && Objects.equals(endDate, that.endDate) && Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nbrGuest, userId, roomId, endDate, startDate);
    }
}
