package com.microservice.hotel.Controller;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.hotel.Model.Hotel;
import com.microservice.hotel.Service.HotelService;


@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    // post
    @PostMapping(value= "/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        this.hotelService.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(hotel);
    }
    // get 
    @GetMapping(value="/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        
        Hotel hotel = this.hotelService.getHotelById(hotelId);

        return ResponseEntity.status(HttpStatus.SC_SUCCESS).body(hotel);
    }
    
    @GetMapping(value ="/all")
    public ResponseEntity<List<Hotel>> getAllHotels(){

        return ResponseEntity.status(HttpStatus.SC_SUCCESS).body(this.hotelService.getAllHotels());
    }
    // update
    // delete
}
