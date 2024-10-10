package com.microservice.HotelService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.HotelService.dto.HotelDto;
import com.microservice.HotelService.entities.Hotel;
import com.microservice.HotelService.exception.ResourceNotFoundException;
import com.microservice.HotelService.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImlp implements HotelService {
    @Autowired
    private HotelRepository repository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public HotelDto create(Hotel hotel) {

        Hotel save = repository.save(hotel);
        HotelDto hotelDto = objectMapper.convertValue(save, HotelDto.class);
        return hotelDto;
    }

    @Override
    public List<HotelDto> getAll() {
        List<Hotel> all = repository.findAll();
        List<HotelDto> hotelList = all.stream().map(item -> {
            HotelDto hotelDto = objectMapper.convertValue(item, HotelDto.class);
            return hotelDto;
        }).toList();
        return hotelList;
    }

    @Override
    public HotelDto get(String id) {
        Hotel hotel = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel Not Found of Userid; " + id));
        HotelDto hotelDto = objectMapper.convertValue(hotel, HotelDto.class);
        return hotelDto;
    }
}
