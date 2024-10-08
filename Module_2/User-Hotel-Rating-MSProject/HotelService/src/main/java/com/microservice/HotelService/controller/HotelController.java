package com.microservice.HotelService.controller;

import com.microservice.HotelService.entities.Hotel;
import com.microservice.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel() {
        List<Hotel> all = hotelService.getAll();

        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelbyid(@PathVariable String id) {
        Hotel hotel = hotelService.get(id);
        return new ResponseEntity<>(hotel, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelService.create(hotel);

        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }


}
