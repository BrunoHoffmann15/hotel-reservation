package com.personal.hotel.management.controller;

import com.personal.hotel.management.domain.hotel.Hotel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController("/hotels")
public class HotelController {

    @PostMapping
    public ResponseEntity<Void> create() throws URISyntaxException {
        return ResponseEntity.created(new URI("/hotels/" + 1)).build();
    }

    @GetMapping("{id-hotel}")
    public ResponseEntity<Hotel> get() {
        return ResponseEntity.ok(new Hotel());
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll() {
        return ResponseEntity.ok(List.of(new Hotel()));
    }

    @PostMapping("{id-hotel}/rooms/{id-room}")
    public ResponseEntity<Void> addRoom() {
        return ResponseEntity.noContent().build();
    }
}
