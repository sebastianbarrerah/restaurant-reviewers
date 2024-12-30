package org.example.models;

import org.example.controllers.interfaces.Observer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Restaurant {
    private String name;
    private String city;
    private String schedule;
    private String description;
    private List<ReviewRestaurant> reviews = new ArrayList<>();
    private LinkedList<Menu> menus = new LinkedList<>();
    private Double qualification;
    private List<Observer> observers = new ArrayList<>();

    public Restaurant() {}

    public Restaurant( String name, String city, String description) {
        this.name = name;
        this.city = city;
        this.description = description;
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

    public void addReview(ReviewRestaurant review) {
        this.reviews.add(review);
        updateQualification();
    }

    public List<ReviewRestaurant> getReviews() {
        return this.reviews;
    }

    public void setReviews(List<ReviewRestaurant> reviews) {
        this.reviews = reviews;
    }

    public LinkedList<Menu> getMenus() {
        return this.menus;
    }
    public void setMenus(LinkedList<Menu> menus) {
        this.menus = menus;
    }

    public void addMenu(Menu menu) {
        this.menus.add(menu);
    }


    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.name, this.qualification);
        }
    }

    public void updateQualification() {
        double oldQualification = this.qualification;
        this.qualification = reviews.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);

        if (this.qualification != oldQualification) {
            notifyObservers();
        }
    }

    public String toString() {
        return "Restaurant: " + this.name + "\n" +
                "Reviews: " + this.reviews.size() + "\n" +
                "Menus: " + this.menus.size() + "\n" +
                "Rating: " + this.qualification + "\n" +
                "Name: " + this.name + "\n" +
                "City: " + this.city + "\n" +
                "Schedule: " + this.schedule + "\n" +
                "Description: " + this.description + "\n" +
                "Qualification: " + this.qualification + "\n";
    }
}
