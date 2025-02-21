package com.pantelisgavalas.lil.landon_hotel.data.repository;

import com.pantelisgavalas.lil.landon_hotel.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
