package org.example.models;

import java.util.List;

public class Restaurant {
    private String id;
    private String name;
    private String city;
    private String schedule;
    private String description;
    private List<Review> reviews;
    private List<Menu> menus;
    private Double qualification;

    public Restaurant() {}

    public Restaurant(String id, String name, String city, String description) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.description = description;
    }

    public void qualificationPromedy() {
        this.qualification = 0.0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
