package org.example.models;

import org.example.constants.ReviewType;

public class ReviewFactory {

    public static Review createReview(ReviewType type, Users user, String comment, Double rating, Integer flavor, Integer presentation, Integer service, Integer value, Dishes dishes, Integer location, Restaurant restaurant) {
        switch (type) {
            case RESTAURANT:
                return new ReviewRestaurant(user, comment, rating, restaurant, service, value, location);

            case DISH:
                return new ReviewDishes(user, comment, rating, dishes, flavor, presentation, service, value);

            default:
                throw new IllegalArgumentException("Tipo invalido");
        }
    }
}
