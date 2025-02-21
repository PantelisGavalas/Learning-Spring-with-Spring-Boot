package com.pantelisgavalas.lil.landon_hotel.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="guests")
@Data
@ToString
public class Guest {
    @Id
    @Column(name="guest_id")
    // Check IDENTITY vs AUTO GenerationType.
    // In summary:
    // AUTO is more flexible but can lead to issues if Hibernate chooses a strategy
    //      that's not fully supported or configured in your database.
    // IDENTITY is more specific and tells Hibernate to use the database's identity
    //      column feature, which is usually the simplest and most reliable approach.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email_address")
    private String emailAddress;
    @Column(name="address")
    private String address;
    @Column(name="country")
    private String country;
    @Column(name="state")
    private String state;
    @Column(name="phone_number")
    private String phoneNumber;
}
