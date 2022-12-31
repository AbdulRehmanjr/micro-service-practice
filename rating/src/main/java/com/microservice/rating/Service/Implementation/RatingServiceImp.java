package com.microservice.rating.Service.Implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.rating.Database.RatingRepository;
import com.microservice.rating.Model.Rating;
import com.microservice.rating.Service.RatingService;

@Service
public class RatingServiceImp  implements RatingService{


    @Autowired
    private RatingRepository ratingRepo;

    @Override
    public List<Rating> getAllRatings() {
        
        return this.ratingRepo.findAll();
    }

    @Override
    public Rating getRatingById(String ratingId) {
        
        return this.ratingRepo.findById(ratingId).get();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        
        return this.ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        
        return this.ratingRepo.findByHotelId(hotelId);
    }

    @Override
    public Rating createRating(Rating rating) {
        
        String id = UUID.randomUUID().toString();
        rating.setRatingId(id);
        return this.ratingRepo.save(rating);
    }

    

    
}
