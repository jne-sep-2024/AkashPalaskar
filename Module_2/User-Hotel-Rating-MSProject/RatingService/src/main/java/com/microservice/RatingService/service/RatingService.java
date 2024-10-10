package com.microservice.RatingService.service;


import com.microservice.RatingService.dto.RatingDto;
import com.microservice.RatingService.entites.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    List<RatingDto> ratingList ();
    RatingDto getRatingByid(int ratingId);
    List<RatingDto> getRatingByuserId(int userId);
    List<RatingDto> getRatingByhotelId(int hotelId);



    RatingDto createRating(Rating rating);

}
