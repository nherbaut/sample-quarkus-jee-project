package com.hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public  class Reservation {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nbr_guest")
    private Integer nbrGuest;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id", unique = false)
    private Room room;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "total_price")
    private Double totalPrice;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "option_id")
    private Set<ReservationOptions> options = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private String bookingReservationId;

    public Reservation(Integer nbrGuest, User user, Room room, LocalDate startDate, LocalDate endDate, Double totalPrice, Set<ReservationOptions> options, StatusEnum status, String bookingReservationId) {
        this.nbrGuest = nbrGuest;
        this.user = user;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.options = options;
        this.status = status;
        this.bookingReservationId = bookingReservationId;
    }

    public Reservation(Integer nbrGuest, User user, Room room, LocalDate startDate, LocalDate endDate, Double totalPrice, Set<ReservationOptions> options, StatusEnum status) {
        this.nbrGuest = nbrGuest;
        this.user = user;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.options = options;
        this.status = status;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Reservation that = (Reservation) object;
        return Objects.equals(id, that.id) && Objects.equals(nbrGuest, that.nbrGuest) && Objects.equals(user, that.user) && Objects.equals(room, that.room) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(totalPrice, that.totalPrice) && Objects.equals(options, that.options) && status == that.status && Objects.equals(bookingReservationId, that.bookingReservationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nbrGuest, user, room, startDate, endDate, totalPrice, options, status, bookingReservationId);
    }
}
