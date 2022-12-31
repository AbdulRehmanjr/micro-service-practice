package com.microservice.hotel.Service.Implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hotel.Database.HotelRepository;
import com.microservice.hotel.Model.Hotel;
import com.microservice.hotel.Service.HotelService;




@Service
public class HotelServiceImpl  implements HotelService{

    @Autowired
    private HotelRepository hotelRepo;


    @Override
    public Hotel getHotelById(String hotelId) {
        return this.hotelRepo.findById(hotelId).get();
    }

    @Override
    public List<Hotel> getAllHotels() {
        
        return this.hotelRepo.findAll();
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String id = UUID.randomUUID().toString();

        hotel.setHotelId(id);
        return this.hotelRepo.save(hotel);
    }
    
}
