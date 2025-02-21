package com.pantelisgavalas.lil.landon_hotel.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="rooms")
@Data
@ToString
public class Room {

    @Id
    @Column(name="room_id")
    // Check IDENTITY vs AUTO GenerationType.
    // In summary:
    // AUTO is more flexible but can lead to issues if Hibernate chooses a strategy
    //      that's not fully supported or configured in your database.
    // IDENTITY is more specific and tells Hibernate to use the database's identity
    //      column feature, which is usually the simplest and most reliable approach.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="room_number")
    private String roomNumber;
    @Column(name="bed_info")
    private String bedInfo;
}

