package com.microservice.RatingService.service;


import com.microservice.RatingService.entites.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    List<Rating> ratingList ();
    Rating getRatingByid(int ratingId);
    List<Rating> getRatingByuserId(int userId);
    List<Rating> getRatingByhotelId(int hotelId);



    Rating createRating(Rating rating);

}
