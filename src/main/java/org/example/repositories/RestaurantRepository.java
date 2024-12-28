package org.example.repositories;

import org.example.models.Menu;
import org.example.models.Restaurant;
import org.example.models.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestaurantRepository {

    private static RestaurantRepository instance;
    private List<Restaurant> restaurants;

    private RestaurantRepository() {
        restaurants = new ArrayList<>();
    }

    public static RestaurantRepository getInstance() {
        if (instance == null) {
            instance = new RestaurantRepository();
        }
        return instance;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void editRestaurant(Restaurant restaurant) {
        restaurants.remove(restaurant);
        restaurants.add(restaurant);
    }

    public void deleteRestaurant(Restaurant restaurant) {
        restaurants.remove(restaurant);
    }

    public List<Restaurant> showRestaurants() {
        return restaurants;
    }

    public List<Review> getReviewsToRestaurant() {
        return List.of();
    }

    public Map<Restaurant, Menu> getMenusToRestaurant() {
        return Map.of();
    }




}
