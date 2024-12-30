package org.example.repositories;

import org.example.models.Review;
import org.example.models.ReviewDishes;
import org.example.models.ReviewRestaurant;

import java.util.ArrayList;
import java.util.List;

public class ReviewRepository {
    private static ReviewRepository instance;
    private List<Review> reviews;

    private ReviewRepository() {
        reviews = new ArrayList<>();
    }

    public static ReviewRepository getInstance() {
        if (instance == null) {
            instance = new ReviewRepository();
        }
        return instance;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public List<ReviewRestaurant> getRestaurantReviews(String restaurantName) {
        List<ReviewRestaurant> filteredReviews = new ArrayList<>();
        for (Review review : reviews) {
            if (review instanceof ReviewRestaurant) {
                ReviewRestaurant restaurantReview = (ReviewRestaurant) review;
                if (restaurantReview.getRestaurant().getName().equalsIgnoreCase(restaurantName)) {
                    filteredReviews.add(restaurantReview);
                }
            }
        }
        return filteredReviews;
    }

    public List<ReviewDishes> getDishReviews(String dishName) {
        List<ReviewDishes> filteredReviews = new ArrayList<>();
        for (Review review : reviews) {
            if (review instanceof ReviewDishes) {
                ReviewDishes dishReview = (ReviewDishes) review;
                if (dishReview.getDishes().getName().equalsIgnoreCase(dishName)) {
                    filteredReviews.add(dishReview);
                }
            }
        }
        return filteredReviews;
    }
}
