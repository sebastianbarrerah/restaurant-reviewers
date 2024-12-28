package org.example.models;

public class ReviewRestaurant extends Review {

    private Restaurant restaurant;
    private Integer Service;
    private Integer Value;
    private Integer location;

    public ReviewRestaurant() {}

    public ReviewRestaurant(Users user, String comment, Double rating, Restaurant restaurant, Integer Service, Integer Value, Integer location) {
        super(user, comment, rating);
        this.restaurant = restaurant;
        this.Service = Service;
        this.Value = Value;
        this.location = location;
    }

    public String showReview() {
        return "Restaurant: " + this.restaurant.getName() + "\n" +
                "Service: " + this.Service + "\n" +
                "Value: " + this.Value + "\n" +
                "Location: " + this.location + "\n" +
                "Comment: " + this.getComment() + "\n" +
                "Rating: " + this.getRating() + "\n";
    }
}
