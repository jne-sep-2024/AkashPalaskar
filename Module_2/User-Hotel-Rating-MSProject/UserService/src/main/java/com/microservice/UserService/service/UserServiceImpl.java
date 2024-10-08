package com.microservice.UserService.service;

import com.microservice.UserService.entities.User;
import com.microservice.UserService.exception.ResourceNotFoundException;
import com.microservice.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserRepository repository;


    @Override
    public User saveUser(User user) {
        String Id = UUID.randomUUID().toString();
        user.setUserId(Id);
        User savedUser = repository.save(user);
        return savedUser;
    }

    @Override
    public List<User> getAllUser() {
        List<User> all = repository.findAll();
        return all;
    }

    @Override
    public User getUser(String userId) {
        User user = repository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User Not Found od Id: "+userId));
        return user;
    }

    @Override
    public void deleteUser(String userid) {
        repository.deleteById(userid);

    }

    @Override
    public User updateUser(User user) {
        User saveUser = repository.save(user);
        return saveUser;
    }
}
