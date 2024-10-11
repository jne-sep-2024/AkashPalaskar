package com.microservice.RatingService.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.RatingService.dto.RatingDto;
import com.microservice.RatingService.entites.Rating;
import com.microservice.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RatingService ratingService;

    @KafkaListener(topics = "rating-topic", groupId = "group-1")
    public void createRating(String value) throws JsonProcessingException {
        Rating rating = objectMapper.readValue(value, Rating.class);
        System.out.println(rating.getFeedback());
        System.out.println(rating);
        RatingDto savedRating = ratingService.createRating(rating);
        System.out.println(rating);
    }
}
