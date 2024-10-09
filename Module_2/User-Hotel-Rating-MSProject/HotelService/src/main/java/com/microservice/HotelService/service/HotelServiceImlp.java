package com.microservice.HotelService.service;

import com.microservice.HotelService.entities.Hotel;
import com.microservice.HotelService.exception.ResourceNotFoundException;
import com.microservice.HotelService.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImlp implements  HotelService{
    @Autowired
    private HotelRepository repository;


    @Override
    public Hotel create(Hotel hotel) {
//        String Id = UUID.randomUUID().toString();
//        hotel.setId(Id);
        Hotel save = repository.save(hotel);
        return save;
    }

    @Override
    public List<Hotel> getAll() {
        List<Hotel> all = repository.findAll();
        return all;
    }

    @Override
    public Hotel get(String id) {
        Hotel hotel = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel Not Found of Userid; "+id));

        return hotel;
    }
}
