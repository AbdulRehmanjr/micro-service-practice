package com.microservice.rating.Service;

import java.util.List;

import com.microservice.rating.Model.Rating;

public interface RatingService {
    
    // get 

    List<Rating> getAllRatings();

    Rating getRatingById(String ratingId);

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);

    // post 

    Rating createRating(Rating rating);
    
    //TODO put

    //TODO DELETE
}
