package com.microservice.user.Model;

public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private  int rating;
    private  String feedback;
    
    private Hotel hotel;
    
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
    public Hotel getHotel() {
        return hotel;
    }
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    @Override
    public String toString() {
        return "Rating [ratingId=" + ratingId + ", userId=" + userId + ", hotelId=" + hotelId + ", rating=" + rating
                + ", feedback=" + feedback + ", hotel=" + hotel + "]";
    }
}
