package com.microservice.UserService.service;

//import com.microservice.UserService.client.HotelService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.UserService.client.RatingService;
import com.microservice.UserService.dto.Hotel;
import com.microservice.UserService.dto.Rating;
import com.microservice.UserService.dto.UserDto;
import com.microservice.UserService.entities.User;
import com.microservice.UserService.exception.ResourceNotFoundException;
import com.microservice.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private WebClient webClient;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public UserDto saveUser(UserDto userDto) {
        User user =  objectMapper.convertValue(userDto,User.class);
        User savedUser = repository.save(user);
        UserDto savedUserDto = objectMapper.convertValue(savedUser,UserDto.class);
        return savedUserDto;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> all = repository.findAll();

        List<UserDto> list = all.stream().map(item -> {
            UserDto userDto = objectMapper.convertValue(item,UserDto.class);
             userDto = getUser(item.getUserId());

                    return userDto;
                }
        ).toList();
        return list;
    }

    @Override
    public UserDto getUser(int userId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found od Id: " + userId));
        UserDto userDto = objectMapper.convertValue(user,UserDto.class);

        List<Rating> ratingList = ratingService.getratingbyUserId(user.getUserId()).getBody();

        List<Rating> Rating = ratingList.stream().map(rating ->
                {
                    rating.setHotel(
                            webClient.get()
                                    .uri("/hotels/" + rating.getHotelId())
                                    .retrieve()
                                    .bodyToMono(Hotel.class)
                                    .block()
                    );

                    return rating;
                }
        ).toList();

        userDto.setRatings(Rating);
        return userDto;
    }

    @Override
    public void deleteUser(int userid) {
        repository.deleteById(userid);
    }

    @Override
    public UserDto updateUser(User user) {
        User saveUser = repository.save(user);
        UserDto userDto = objectMapper.convertValue(saveUser,UserDto.class);
        return userDto;
    }
}
