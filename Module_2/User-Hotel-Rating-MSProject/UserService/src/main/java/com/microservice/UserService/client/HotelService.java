//package com.microservice.UserService.client;
//
//import com.microservice.UserService.dto.Hotel;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@FeignClient(name = "HOTELSERVICE")
//public interface HotelService {
//
//    @GetMapping("/hotels/{id}")
//    public ResponseEntity<Hotel> getHotelbyid(@PathVariable int id);
//
//}
