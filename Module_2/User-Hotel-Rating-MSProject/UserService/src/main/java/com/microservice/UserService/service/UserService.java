package com.microservice.UserService.service;

import com.microservice.UserService.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    //create
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single user of given userId
    User getUser(int userId);

    //delete User
    void deleteUser(int userid);

    //update User
    User updateUser(User user);
}
