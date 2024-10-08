package com.microservice.HotelService.service;

import com.microservice.HotelService.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    //create
    Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get single
    Hotel get (String id);


}
