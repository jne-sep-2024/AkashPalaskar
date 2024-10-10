package com.microservice.UserService.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {

//    private int ratingId;
//    private int userId;

    private int hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}
