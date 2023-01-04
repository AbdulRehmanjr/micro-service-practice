package com.microservice.user.Controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.user.Model.User;
import com.microservice.user.Service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody User user){

        return ResponseEntity.ok().body(this.userService.saveUser(user));
    }
    int retry_count = 1;
    @GetMapping(value="/{userId}")
    // @CircuitBreaker(name="RATING_HOTEL_BREAKER",fallbackMethod = "ratingHotelFallBack")
    @Retry(name = "RATING_HOTEL_SERVICES",fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        log.info("Retry cound"+retry_count);
        retry_count++;
        return ResponseEntity.ok().body(this.userService.getUser(userId));
    }
    
    // creating fall back for circuit breaker
    public ResponseEntity<User> ratingHotelFallBack(String userId,Exception ex){
        
        log.info("Fallback method service down: {}",ex.getMessage());
        User user = new User();
        user.setName("Dummy");
        user.setEmail("dummy@email.com");
        user.setUserId("abc123");
        user.setAbout("about");
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
        
}
