package com.microservice.rating.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="RATINGTABLE")
public class Rating {
    
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private  int rating;
    private  String feedback;
    
    public String getRatingId() {
        return ratingId;
    }
    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getHotelId() {
        return hotelId;
    }
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    @Override
    public String toString() {
        return "Rating [ratingId=" + ratingId + ", userId=" + userId + ", hotelId=" + hotelId + ", rating=" + rating
                + ", feedback=" + feedback + "]";
    }
}
