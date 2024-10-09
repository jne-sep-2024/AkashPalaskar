package com.microservice.UserService.service;

//import com.microservice.UserService.client.HotelService;
import com.microservice.UserService.client.RatingService;
import com.microservice.UserService.config.WebClientConfig;
import com.microservice.UserService.dto.Hotel;
import com.microservice.UserService.dto.Rating;
import com.microservice.UserService.entities.User;
import com.microservice.UserService.exception.ResourceNotFoundException;
import com.microservice.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Stream;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RatingService ratingService;

//    @Autowired
//    private HotelService hotelService;
    @Autowired
    private WebClient webClient;

//    private final WebClient webClient;
//
//    public UserServiceImpl(WebClient webClientBuilder) {
//        this.webClient = webClientBuilder;
//    }

    @Override
    public User saveUser(User user) {
//        String Id = UUID.randomUUID().toString();
//        user.setUserId(Id);
        User savedUser = repository.save(user);
        return savedUser;
    }

    @Override
    public List<User> getAllUser() {
        List<User> all = repository.findAll();

        List<User> UserList = all.stream().map(item -> {

//                    item.setRatings(
//                            ratingService.getratingbyUserId(item.getUserId()).getBody());


                    item = getUser(item.getUserId());
                    return item;
                }
        ).toList();

        return UserList;
    }

    @Override
    public User getUser(int userId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found od Id: " + userId));
        List<Rating> ratingList = ratingService.getratingbyUserId(user.getUserId()).getBody();

        System.out.println(ratingList);

        List<Rating> Rating = ratingList.stream().map(rating ->
                {
                    rating.setHotel(
                            webClient.get()
//                            .uri("http://HOTELSERVICE/hotels/"+rating.getHotelId())
                                    .uri("/hotels/"+rating.getHotelId())
                            .retrieve()
                            .bodyToMono(Hotel.class)
                            .block()
                    );

                    return rating;
                }
        ).toList();

//        Hotel hotel = webClient.get()
//                .uri("/hotels/1")
//                .retrieve()
//                .bodyToMono(Hotel.class)
//                .block();
//
//        System.out.println(hotel);

        System.out.println(Rating);


        user.setRatings(Rating);
        return user;
    }

    @Override
    public void deleteUser(int userid) {
        repository.deleteById(userid);

    }

    @Override
    public User updateUser(User user) {
        User saveUser = repository.save(user);
        return saveUser;
    }
}
