package com.microservice.user.Service;

import java.util.List;

import com.microservice.user.Model.User;

public interface UserService {
 
     //user operations

    //create
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single user of given userId

    User getUser(String userId);

    //TODO: delete
    //TODO: update
}
