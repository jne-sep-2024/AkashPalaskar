package com.microservice.HotelService.service;

import com.microservice.HotelService.dto.HotelDto;
import com.microservice.HotelService.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    //create
    HotelDto create(Hotel hotel);

    //get all
    List<HotelDto> getAll();

    //get single
    HotelDto get (String id);


}
