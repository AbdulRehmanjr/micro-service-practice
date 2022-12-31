package com.microservice.rating.Controller;

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

import com.microservice.rating.Model.Rating;
import com.microservice.rating.Service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    

    @Autowired
    private RatingService ratingService;


    @PostMapping("/save")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){

        return ResponseEntity.ok().body(this.ratingService.createRating(rating));
    }
    
    @GetMapping(value="/{ratingId}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String ratingId) {
        return ResponseEntity.status(HttpStatus.SC_SUCCESS).body(this.ratingService.getRatingById(ratingId));
    }
    
    @GetMapping(value="/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.SC_SUCCESS).body(this.ratingService.getRatingByUserId(userId));
    }

    @GetMapping(value="/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.status(HttpStatus.SC_SUCCESS).body(this.ratingService.getRatingByHotelId(hotelId));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Rating>> getAllRating() {
        List<Rating> allRating = this.ratingService.getAllRatings();
        return ResponseEntity.ok(allRating);
    }

}
