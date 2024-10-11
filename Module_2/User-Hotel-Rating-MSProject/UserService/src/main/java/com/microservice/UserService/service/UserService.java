package com.microservice.UserService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservice.UserService.dto.Rating;
import com.microservice.UserService.dto.UserDto;
import com.microservice.UserService.entities.User;

import java.util.List;

public interface UserService {

    //create user
    UserDto saveUser(UserDto user);

    //get all user
    List<UserDto> getAllUser();

    //get single user of given userId
    UserDto getUser(int userId);

    //delete User
    void deleteUser(int userid);

    //update User
    UserDto updateUser(User user);

    //give rating to the hotel
     Rating createRating(Rating rating) throws JsonProcessingException;
}
