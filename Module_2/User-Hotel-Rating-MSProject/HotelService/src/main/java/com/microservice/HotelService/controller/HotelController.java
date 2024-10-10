package com.microservice.HotelService.controller;

import com.microservice.HotelService.dto.HotelDto;
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
    public ResponseEntity<List<HotelDto>> getAllHotel() {
        List<HotelDto> all = hotelService.getAll();

        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> getHotelbyid(@PathVariable String id) {
        HotelDto hotel = hotelService.get(id);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<HotelDto> createHotel(@RequestBody Hotel hotel) {
        HotelDto savedHotel = hotelService.create(hotel);

        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }


}
