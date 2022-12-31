package com.microservice.hotel.Service;

import java.util.List;

import com.microservice.hotel.Model.Hotel;

public interface HotelService {
    
    //get 

    Hotel getHotelById(String hotelId);

    List<Hotel> getAllHotels();
    //post 

    Hotel saveHotel(Hotel hotel);
    //TODO PUT

    //TODO DELETE
}
