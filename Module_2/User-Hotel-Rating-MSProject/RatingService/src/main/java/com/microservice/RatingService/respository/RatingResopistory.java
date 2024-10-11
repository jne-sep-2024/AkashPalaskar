package com.microservice.RatingService.respository;


import com.microservice.RatingService.entites.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingResopistory extends JpaRepository<Rating, Integer> {
    List<Rating> findByhotelId(int hotelId);

    List<Rating> findByuserId(int userId);
}
