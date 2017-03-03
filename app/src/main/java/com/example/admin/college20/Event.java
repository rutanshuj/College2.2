package com.example.admin.college20;


/**
 * Created by RutanshuJhaveri on 2/5/2017.
 */

public class Event {
    private String title, desc, location, category, price, imageUrl;

    public Event(String title, String imageUrl, String price, String category, String location, String desc) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.price = price;
        this.category = category;
        this.location = location;
        this.desc = desc;
    }
    public Event(){

    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
