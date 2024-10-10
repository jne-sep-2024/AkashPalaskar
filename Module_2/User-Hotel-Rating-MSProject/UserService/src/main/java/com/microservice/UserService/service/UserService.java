package com.microservice.UserService.service;

import com.microservice.UserService.dto.UserDto;
import com.microservice.UserService.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    //create
    UserDto saveUser(UserDto user);

    //get all user
    List<UserDto> getAllUser();

    //get single user of given userId
    UserDto getUser(int userId);

    //delete User
    void deleteUser(int userid);

    //update User
    UserDto updateUser(User user);
}
