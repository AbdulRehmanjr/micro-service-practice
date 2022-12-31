package com.microservice.rating.Database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.rating.Model.Rating;

public interface RatingRepository extends JpaRepository<Rating,String>{

    public List<Rating> findByUserId(String userId);

    public List<Rating> findByHotelId(String HotelId);
    
}
