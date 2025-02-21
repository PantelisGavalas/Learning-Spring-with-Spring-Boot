package com.pantelisgavalas.lil.landon_hotel.web.api;

import com.pantelisgavalas.lil.landon_hotel.data.entity.Guest;
import com.pantelisgavalas.lil.landon_hotel.data.repository.GuestRepository;
import com.pantelisgavalas.lil.landon_hotel.web.exception.NotFoundException;
import com.pantelisgavalas.lil.landon_hotel.web.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/guests")
public class GuestApiController {

    public final GuestRepository guestRepository;

    public GuestApiController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    // READ API
    @GetMapping
    public List<Guest> getAllGuests() {
        return this.guestRepository.findAll();
    }

    // CREATE API
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Guest createGuest(@RequestBody Guest guest) {
        return this.guestRepository.save(guest);
    }

    // READ API
    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable("id")long id) {
        Optional<Guest> guest = this.guestRepository.findById(id);
        if (guest.isEmpty()) {
            throw new NotFoundException("Guest with id: " + id + " not found.");
        }
        return guest.get();
    }

    // UPDATE API
    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable("id")long id, Guest guest) {
        if (id != guest.getId()) {
            throw new BadRequestException("id on path doesn't match body");
        }
        return this.guestRepository.save(guest);
    }

    // DELETE API
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteGuest(@PathVariable("id")long id) {
        this.guestRepository.deleteById(id);
    }
}
