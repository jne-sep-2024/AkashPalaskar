package com.microservice.UserService.service;

//import com.microservice.UserService.client.HotelService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.UserService.client.RatingService;
import com.microservice.UserService.dto.Hotel;
import com.microservice.UserService.dto.Rating;
import com.microservice.UserService.dto.UserDto;
import com.microservice.UserService.entities.User;
import com.microservice.UserService.exception.ResourceNotFoundException;
import com.microservice.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private WebClient webClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate kafkaTemplate;


    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = objectMapper.convertValue(userDto, User.class);
        User savedUser = userRepository.save(user);
        return objectMapper.convertValue(savedUser, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(User::getUserId).map(this::getUser).toList();
    }

    @Override
    public UserDto getUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found od Id: " + userId));
        List<Rating> ratings = ratingService.getratingbyUserId(user.getUserId()).getBody();  // getratingbyUserId is method from feign client
        UserDto userDto = objectMapper.convertValue(user, UserDto.class);
        ratings.forEach(rating -> rating
                .setHotel(webClient.get()
                        .uri("/hotels/" + rating.getHotelId())
                        .retrieve()
                        .bodyToMono(Hotel.class)
                        .block()));
        userDto.setRatings(ratings);
        return userDto;
    }

    @Override
    public void deleteUser(int userid) {
        userRepository.deleteById(userid);
    }

    @Override
    public UserDto updateUser(User user) {
        User saveUser = userRepository.save(user);
        return objectMapper.convertValue(saveUser, UserDto.class);
    }

    @Override
    public Rating createRating(Rating rating) throws JsonProcessingException {
        kafkaTemplate.send("rating-topic", objectMapper.writeValueAsString(rating));
        return rating;
    }
}
