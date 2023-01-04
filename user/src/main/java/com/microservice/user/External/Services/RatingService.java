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
    @GetMapping("/ratings/user/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable String userId);

    //POST
    @PostMapping("/ratings/save")
    public ResponseEntity<Rating> createRating(Rating values);

    //PUT
    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating rating);


    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}
