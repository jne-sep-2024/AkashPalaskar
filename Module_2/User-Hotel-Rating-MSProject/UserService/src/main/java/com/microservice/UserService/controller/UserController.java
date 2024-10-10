package com.microservice.UserService.controller;

import com.microservice.UserService.dto.UserDto;
import com.microservice.UserService.entities.User;
import com.microservice.UserService.service.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        UserDto savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int userId) {
        UserDto savedUser = userService.getUser(userId);
        return new ResponseEntity<>(savedUser,HttpStatus.FOUND);

    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser,HttpStatus.FOUND);

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.FOUND);

    }

    @PostMapping("/update")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody User user) {

        UserDto updateUser = userService.updateUser(user);

        return new ResponseEntity<>(updateUser,HttpStatus.OK);

    }

}
