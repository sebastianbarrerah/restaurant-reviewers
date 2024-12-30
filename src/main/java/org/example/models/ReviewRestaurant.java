package org.example.models;

public class ReviewRestaurant extends Review {

    private Restaurant restaurant;
    private Integer service;
    private Integer value;
    private Integer location;

    public ReviewRestaurant() {}

    public ReviewRestaurant(Users user, String comment, Double rating, Restaurant restaurant, Integer service, Integer value, Integer location) {
        super(user, comment, rating);
        this.restaurant = restaurant;
        this.service = service;
        this.value = value;
        this.location = location;
    }

    public String showReview() {
        return "Restaurant: " + this.restaurant.getName() + "\n" +
                "Service: " + this.service + "\n" +
                "Value: " + this.value + "\n" +
                "Location: " + this.location + "\n" +
                "Comment: " + this.getComment() + "\n" +
                "Rating: " + this.getRating() + "\n";
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
