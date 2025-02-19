package com.pantelisgavalas.lil.landon_hotel;

import com.pantelisgavalas.lil.landon_hotel.data.entity.Guest;
import com.pantelisgavalas.lil.landon_hotel.data.entity.Reservation;
import com.pantelisgavalas.lil.landon_hotel.data.entity.Room;
import com.pantelisgavalas.lil.landon_hotel.data.repository.GuestRepository;
import com.pantelisgavalas.lil.landon_hotel.data.repository.ReservationRepository;
import com.pantelisgavalas.lil.landon_hotel.data.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("***GUESTS***");
        List<Guest> guests = this.guestRepository.findAll();
        guests.forEach(System.out::println);

        System.out.println("***ROOMS***");
        List<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(System.out::println);
        //Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
        //System.out.println(room);

        System.out.println("***RESERVATIONS***");
        List<Reservation> reservations = this.reservationRepository.findAll();
        reservations.forEach(System.out::println);

    }
}
