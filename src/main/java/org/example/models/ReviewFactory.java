package org.example.models;

import org.example.constants.ReviewType;

public class ReviewFactory {

    public static Review createReview(ReviewType type, Users user, String comment, Double rating,
                                      Integer flavor, Integer presentation, Integer service, Integer value,
                                      Dishes dishes, Integer location, Restaurant restaurant) {
        if (type == ReviewType.RESTAURANT) {
            // Creamos una reseña de restaurante, con dishes a null.
            return new ReviewRestaurant(user, comment, rating, restaurant, service, value, location);
        } else if (type == ReviewType.DISH) {
            // Creamos una reseña de plato, con restaurant a null.
            return new ReviewDishes(user, comment, rating, dishes, flavor, presentation, service, value);
        } else {
            throw new IllegalArgumentException("Tipo de reseña no válido");
        }
    }
}
