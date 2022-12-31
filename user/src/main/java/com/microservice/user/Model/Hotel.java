package com.microservice.user.Model;

public class Hotel {
   
    private  String hotelId;
    private  String name;
    private  String location;
    private  String about;
    public String getHotelId() {
        return hotelId;
    }
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }
    @Override
    public String toString() {
        return "Hotel [hotelId=" + hotelId + ", name=" + name + ", location=" + location + ", about=" + about + "]";
    }
}
