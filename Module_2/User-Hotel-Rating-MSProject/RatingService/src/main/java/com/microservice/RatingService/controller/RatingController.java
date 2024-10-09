package com.microservice.RatingService.controller;

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
    public ResponseEntity<List<Rating>> ratingList() {
        List<Rating> ratings = ratingService.ratingList();
        return new ResponseEntity<>(ratings, HttpStatus.OK);

    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRatinf(@PathVariable int ratingId) {
        Rating ratingByid = ratingService.getRatingByid(ratingId);
        return new ResponseEntity<>(ratingByid, HttpStatus.FOUND);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getratingbyUserId(@PathVariable int userId) {
        List<Rating> ratingByuserId = ratingService.getRatingByuserId(userId);
        return new ResponseEntity<>(ratingByuserId, HttpStatus.OK);

    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating> >getRatingByHotelid(@PathVariable int hotelId) {
        List<Rating> ratingByuserId = ratingService.getRatingByhotelId(hotelId);
        return new ResponseEntity<>(ratingByuserId, HttpStatus.OK);

    }


    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating ratingCreated = ratingService.createRating(rating);
        return new ResponseEntity<>(ratingCreated, HttpStatus.CREATED);
    }
}
