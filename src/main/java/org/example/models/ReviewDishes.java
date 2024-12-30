package org.example.models;

public class ReviewDishes extends Review {

    private Dishes dishes;
    private Integer flavor;
    private Integer presentation;
    private Integer service;
    private Integer value;

    public ReviewDishes() {}

    public ReviewDishes(Users user, String comment, Double rating, Dishes dishes, Integer flavor, Integer presentation, Integer service, Integer value) {
        super(user, comment, rating);
        this.dishes = dishes;
        this.flavor = flavor;
        this.presentation = presentation;
        this.service = service;
        this.value = value;
    }

    public String showReview() {
        return "Dishes: " + this.dishes.getName() + "\n" +
                "Flavor: " + this.flavor + "\n" +
                "Presentation: " + this.presentation + "\n" +
                "Service: " + this.service + "\n" +
                "Value: " + this.value + "\n" +
                "Comment: " + this.getComment() + "\n" +
                "Rating: " + this.getRating() + "\n";
    }

    public Dishes getDishes() {
        return dishes;
    }
}