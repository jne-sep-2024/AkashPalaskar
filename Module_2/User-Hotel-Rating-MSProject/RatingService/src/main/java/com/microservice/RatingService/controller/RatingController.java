package com.microservice.RatingService.controller;

import com.microservice.RatingService.dto.RatingDto;
import com.microservice.RatingService.entites.Rating;
import com.microservice.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping
    public ResponseEntity<List<RatingDto>> ratingList() {
        List<RatingDto> ratings = ratingService.ratingList();
        return new ResponseEntity<>(ratings, HttpStatus.OK);

    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<RatingDto> getRatinf(@PathVariable int ratingId) {
        RatingDto ratingByid = ratingService.getRatingByid(ratingId);
        return new ResponseEntity<>(ratingByid, HttpStatus.FOUND);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RatingDto>> getratingbyUserId(@PathVariable int userId) {
        List<RatingDto> ratingByuserId = ratingService.getRatingByuserId(userId);
        return new ResponseEntity<>(ratingByuserId, HttpStatus.OK);

    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<RatingDto> >getRatingByHotelid(@PathVariable int hotelId) {
        List<RatingDto> ratingByuserId = ratingService.getRatingByhotelId(hotelId);
        return new ResponseEntity<>(ratingByuserId, HttpStatus.OK);

    }


    @PostMapping
    public ResponseEntity<RatingDto> createRating(@RequestBody Rating rating) {
        RatingDto ratingCreated = ratingService.createRating(rating);
        return new ResponseEntity<>(ratingCreated, HttpStatus.CREATED);
    }
}
