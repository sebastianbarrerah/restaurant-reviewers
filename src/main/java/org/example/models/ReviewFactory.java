package org.example.models;

import org.example.constants.ReviewType;

public class ReviewFactory {
    public Review createReview(
            ReviewType type,
            String userName,
            String comment,
            Double rating,
            Integer flavor,
            Integer presentation,
            Integer service,
            Integer value,
            Dishes dish,
            Integer location,
            Restaurant restaurant
    ) {
        switch (type) {
            case RESTAURANT:
                return new ReviewRestaurant(userName, comment, rating, service, value, location, restaurant);
            case DISH:
                return new ReviewDishes(userName, comment, rating, flavor, presentation, service, value, dish);
            default:
                throw new IllegalArgumentException("Tipo de reseña no reconocido: " + type);
        }
    }
}
