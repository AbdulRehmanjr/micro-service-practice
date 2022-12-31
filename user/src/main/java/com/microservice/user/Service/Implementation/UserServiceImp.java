package com.microservice.user.Service.Implementation;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.user.Database.UserRepository;
import com.microservice.user.External.Services.HotelService;
import com.microservice.user.External.Services.RatingService;
import com.microservice.user.Model.Hotel;
import com.microservice.user.Model.Rating;
import com.microservice.user.Model.User;
import com.microservice.user.Service.UserService;

@Service
public class UserServiceImp implements UserService{

    private Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    

    @Override
    public User saveUser(User user) {
        //generate  unique userid
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return this.userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        //implement RATING SERVICE CALL: USING REST TEMPLATE
        return this.userRepo.findAll();
    }

    //get single user
    @Override
    public User getUser(String userId) {
        //get user from database with the help  of user repository
        User user = this.userRepo.findById(userId).get();

        List<Rating> ratingsOfUser = this.ratingService.getRatingsByUserId(user.getUserId());
        logger.info("{}",ratingsOfUser);

        List<Rating> ratingList = ratingsOfUser.stream().map(rating -> {

            Hotel hotel = this.hotelService.getHotel(rating.getHotelId());
            logger.info("{}",hotel);
            rating.setHotel(hotel);
            return rating;
            
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }
}
