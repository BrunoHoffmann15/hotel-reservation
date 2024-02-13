package com.personal.hotel.management.controller;

import com.personal.hotel.management.domain.hotel.Hotel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController("/hotels")
public class HotelController {

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Hotel hotel) throws URISyntaxException {
        return ResponseEntity.created(new URI("/hotels/" + 1)).build();
    }

    @GetMapping("{id-hotel}")
    public ResponseEntity<Hotel> get(@PathVariable("id-hotel") Long idHotel) {
        return ResponseEntity.ok(new Hotel());
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll() {
        return ResponseEntity.ok(List.of(new Hotel()));
    }

    @PostMapping("{id-hotel}/rooms/{id-room}")
    public ResponseEntity<Void> addRoom(@PathVariable("id-hotel") Long idHotel, @PathVariable("id-room") Long idRoom) {
        return ResponseEntity.noContent().build();
    }
}
