package com.pantelisgavalas.lil.landon_hotel.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.sql.Date;

@Entity
@Table(name="reservations")
@Data
@ToString
public class Reservation {

    @Id
    @Column(name="reservation_id")
    // Check IDENTITY vs AUTO GenerationType.
    // In summary:
    // AUTO is more flexible but can lead to issues if Hibernate chooses a strategy
    //      that's not fully supported or configured in your database.
    // IDENTITY is more specific and tells Hibernate to use the database's identity
    //      column feature, which is usually the simplest and most reliable approach.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="room_id")
    private long roomId;
    @Column(name="guest_id")
    private long guestId;
    @Column(name="res_date")
    private Date reservationDate;
}
