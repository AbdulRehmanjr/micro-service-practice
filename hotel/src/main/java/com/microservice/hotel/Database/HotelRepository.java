package com.microservice.hotel.Database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.hotel.Model.Hotel;




public interface HotelRepository extends JpaRepository<Hotel,String>{
    
}
