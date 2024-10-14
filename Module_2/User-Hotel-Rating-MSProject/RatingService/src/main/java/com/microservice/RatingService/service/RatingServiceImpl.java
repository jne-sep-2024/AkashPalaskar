package com.microservice.RatingService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.RatingService.dto.RatingDto;
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
    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public List<RatingDto> ratingList() {
        List<Rating> all = ratingResopistory.findAll();
        List<RatingDto> list = all.stream().map(item -> {
            return objectMapper.convertValue(item, RatingDto.class);
        }).toList();
        return list;
    }

    @Override
    public RatingDto getRatingByid(int ratingId) {
        Rating rating = ratingResopistory.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Rating Not Found"));
        RatingDto ratingDto = objectMapper.convertValue(rating, RatingDto.class);

        System.out.println(ratingDto);
        return ratingDto;
    }

    @Override
    public List<RatingDto> getRatingByuserId(int userId) {
        List<Rating> byuserId = ratingResopistory.findByuserId(userId);
        List<RatingDto> ratingDtoList = byuserId.stream().map(item -> {
            RatingDto ratingDto = objectMapper.convertValue(item, RatingDto.class);
            return ratingDto;
        }).toList();
        return ratingDtoList;
    }

    @Override
    public List<RatingDto> getRatingByhotelId(int hotelId) {
        List<Rating> byhotelId = ratingResopistory.findByhotelId(hotelId);
        List<RatingDto> ratingDtoList = byhotelId.stream().map(item -> {
            return objectMapper.convertValue(item, RatingDto.class);
        }).toList();
        return ratingDtoList;
    }


    @Override
    public RatingDto createRating(Rating rating) {

        Rating savedRating = ratingResopistory.save(rating);
     return objectMapper.convertValue(savedRating, RatingDto.class);
    }
}
