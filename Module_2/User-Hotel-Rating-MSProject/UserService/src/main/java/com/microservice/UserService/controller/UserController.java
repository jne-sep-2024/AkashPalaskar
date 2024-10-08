package com.microservice.UserService.controller;

import com.microservice.UserService.entities.User;
import com.microservice.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User savedUser = userService.getUser(userId);
        return new ResponseEntity<>(savedUser,HttpStatus.FOUND);

    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser,HttpStatus.FOUND);

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
//        List<User> allUser = userService.getAllUser();
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.FOUND);

    }

    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {

//        List<User> allUser = userService.getAllUser();

        User updateUser = userService.updateUser(user);

        return new ResponseEntity<>(updateUser,HttpStatus.FOUND);

    }

}
