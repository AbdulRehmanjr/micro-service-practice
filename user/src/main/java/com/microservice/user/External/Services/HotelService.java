package com.microservice.user.External.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.user.Model.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    
    @GetMapping("/api/v1/hotels/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
