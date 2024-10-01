package com.think.restful_web_service.controler;

import com.think.restful_web_service.dao.User;
import com.think.restful_web_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> retriveAllUser(){
        return  userService.findAll();
    }
    @GetMapping("/users/{id}")
    public User retriveAfindbyUserIdUser(@PathVariable int id){
        return  userService.findById(id);
    }
}
