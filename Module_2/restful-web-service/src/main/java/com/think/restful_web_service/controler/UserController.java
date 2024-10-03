package com.think.restful_web_service.controler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.think.restful_web_service.ExceptionHandling.UserNotFoundException;
import com.think.restful_web_service.dao.User;
import com.think.restful_web_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
//@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> retriveAllUser() {
        System.out.println(userService.findAll());
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retriveAfindbyUserIdUser(@PathVariable int id) throws UserNotFoundException {
        User user = userService.findById(id);
        if(user==null){
            throw new UserNotFoundException("Id :" +id+" Not Found");
        }

        EntityModel entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUser());
        WebMvcLinkBuilder deletelink = linkTo(methodOn(this.getClass()).deleteByid(1));


        entityModel.add(link.withRel("all-users"));
        entityModel.add(deletelink.withRel("delete-user"));

        return entityModel;
    }



    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid  @RequestBody User user) throws URISyntaxException {
        User userAdded = userService.save(user);
        System.out.println(userAdded);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userAdded.getId())
                .toUri();
//        return ResponseEntity.created(location).build(); // to get location in header

        return new ResponseEntity<>(userAdded, HttpStatus.CREATED);

    }


    @DeleteMapping("/users/{id}")
    public User deleteByid(@PathVariable int id) throws UserNotFoundException {
        User user = userService.deleteById(id);

        if(user==null){
            throw new UserNotFoundException("Id :" +id+" Not Found");
        }
        return user;
    }





}
