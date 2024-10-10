package com.microservice.UserService.controller;


import com.microservice.UserService.dto.JwtResponse;
import com.microservice.UserService.entities.Role;
import com.microservice.UserService.entities.User;
import com.microservice.UserService.exception.PasswordIncorrectException;
import com.microservice.UserService.exception.ResourceNotFoundException;
import com.microservice.UserService.repository.RolesRepository;
import com.microservice.UserService.repository.UserRepository;
import com.microservice.UserService.security.CustomUserDetailsServices;
import com.microservice.UserService.security.JwtHelper;

import java.net.URISyntaxException;
import java.util.logging.Logger;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private JwtHelper helper;

    @Autowired
    private CustomUserDetailsServices userDetailsService;

    @Autowired
    private UserRepository repository;

    @Autowired
    private RolesRepository rolesRepository;

    Logger logger = Logger.getLogger(UserController.class.getName());

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> loginUser(@RequestBody User user) {

        logger.info("login method called");


        User validateUser = repository.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        boolean validate = BCrypt.checkpw(user.getPassword(), validateUser.getPassword());


        if (validate) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(validateUser.getName());
            String token = this.helper.generateToken(userDetails);
            JwtResponse response = new JwtResponse(token, userDetails.getUsername());

            return ResponseEntity.ok(response);

        }
        else {
            throw new PasswordIncorrectException("passward incorrect");
        }


    }


    @PostMapping("/register")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {
        logger.info("user register method called");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        Role role = rolesRepository.findById(1).get();

        user.setRoles(role);
//        List<Post> emptyPostList = new ArrayList<>();
//        user.setPosts(emptyPostList);

        User userAdded = repository.save(user);

        System.out.println("user added");
        System.out.println(userAdded);

        return new ResponseEntity<>(userAdded, HttpStatus.CREATED);

    }

}