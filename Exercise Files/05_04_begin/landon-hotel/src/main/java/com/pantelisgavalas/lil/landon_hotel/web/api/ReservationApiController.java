package com.pantelisgavalas.lil.landon_hotel.web.api;

import com.pantelisgavalas.lil.landon_hotel.data.entity.Reservation;
import com.pantelisgavalas.lil.landon_hotel.data.repository.ReservationRepository;
import com.pantelisgavalas.lil.landon_hotel.web.exception.BadRequestException;
import com.pantelisgavalas.lil.landon_hotel.web.exception.NotFoundException;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {

    public final ReservationRepository reservationRepository;

    public ReservationApiController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // READ API (with extra non-required request parameter for specific date)
    @GetMapping
    public List<Reservation> getAllReservations(@RequestParam(value = "date", required = false)String dateString) {
        if(StringUtils.isNotBlank(dateString)) {
            Date date = new Date(new java.util.Date().getTime());
            return this.reservationRepository.findAllByReservationDate(date);
        }
        return this.reservationRepository.findAll();
    }

    // CREATE API
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    // READ API
    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable("id")long id) {
        Optional<Reservation> reservation = this.reservationRepository.findById(id);
        if (reservation.isEmpty()) {
            throw new NotFoundException("Reservation with id: " + id + " not found.");
        }
        return reservation.get();
    }

    // UPDATE API
    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable("id")long id, @RequestBody Reservation reservation) {
        if (id != reservation.getId()) {
            throw new BadRequestException("id on path doesn't match body");
        }
        return this.reservationRepository.save(reservation);
    }

    // DELETE API
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteReservation(@PathVariable("id")long id) {
        this.reservationRepository.deleteById(id);
    }
}
