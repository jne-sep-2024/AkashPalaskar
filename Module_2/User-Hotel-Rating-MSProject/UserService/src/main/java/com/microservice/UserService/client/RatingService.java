package com.microservice.UserService.client;

import com.microservice.UserService.dto.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    @GetMapping("/rating/user/{userId}")
    public ResponseEntity<List<Rating>> getratingbyUserId(@PathVariable int userId);


}
