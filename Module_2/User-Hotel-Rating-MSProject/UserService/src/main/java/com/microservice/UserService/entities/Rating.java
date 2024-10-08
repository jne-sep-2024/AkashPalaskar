package com.microservice.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    private String ratingId;
    private String UserId;
    private String hotelId;
    private  int rating;
    private String featback;
}
