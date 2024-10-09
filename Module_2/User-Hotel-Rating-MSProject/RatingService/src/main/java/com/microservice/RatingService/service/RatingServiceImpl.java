package com.microservice.RatingService.service;

import com.microservice.RatingService.entites.Rating;
import com.microservice.RatingService.exception.ResourceNotFoundException;
import com.microservice.RatingService.respository.RatingResopistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingResopistory ratingResopistory;

    @Override
    public List<Rating> ratingList() {
        List<Rating> all = ratingResopistory.findAll();
        return all;
    }

    @Override
    public Rating getRatingByid(int ratingId) {
        Rating rating = ratingResopistory.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Rating Not Found"));
        return null;
    }

    @Override
    public List<Rating> getRatingByuserId(int userId) {
        List<Rating> byuserId = ratingResopistory.findByuserId(userId);

        return byuserId;
    }

    @Override
    public List<Rating> getRatingByhotelId(int hotelId) {
        List<Rating> byhotelId = ratingResopistory.findByhotelId(hotelId);
        return byhotelId;
    }



    @Override
    public Rating createRating(Rating rating) {
//        String randomId = UUID.randomUUID().toString();
//        rating.setRatingId(randomId);
        Rating savedRating = ratingResopistory.save(rating);
        return savedRating;
    }
}
