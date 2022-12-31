package com.microservice.user.External.Services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import com.microservice.user.Model.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
    
    

    //get
    @GetMapping("/api/v1/ratings/user/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable String userId);

    //POST
    @PostMapping("/api/v1/ratings/save")
    public ResponseEntity<Rating> createRating(Rating values);

    //PUT
    @PutMapping("/api/v1/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating rating);


    @DeleteMapping("/api/v1/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}
