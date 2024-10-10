package com.think.restful_web_service.controler;

import com.think.restful_web_service.ExceptionHandling.PasswordIncorrectException;
import com.think.restful_web_service.ExceptionHandling.UserNotFoundException;
import com.think.restful_web_service.dao.JwtResponse;
import com.think.restful_web_service.dao.Post;
import com.think.restful_web_service.dao.Role;
import com.think.restful_web_service.dao.User;
import com.think.restful_web_service.repository.RolesRepository;
import com.think.restful_web_service.repository.UserRepository;
import com.think.restful_web_service.security.CustomUserDetailsServices;
import com.think.restful_web_service.security.JwtHelper;
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

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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


        User validateUser = repository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException("User Not Found"));
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



//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }


    @PostMapping("/register")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {
        logger.info("user register method called");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        Role role = rolesRepository.findById(1).get();

        user.setRoles(role);
        List<Post> emptyPostList = new ArrayList<>();
        user.setPosts(emptyPostList);

        User userAdded = repository.save(user);

        System.out.println("user added");
        System.out.println(userAdded);

        return new ResponseEntity<>(userAdded, HttpStatus.CREATED);

    }

}


