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

    public void editRestaurant(String name, String newCity, String newDescription, String newName, String newSchedule) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(name)) {
                restaurant.setCity(newCity);
                restaurant.setDescription(newDescription);
                restaurant.setName(newName);
                restaurant.setSchedule(newSchedule);
            }
        }
        System.out.println("No se encontró un restaurante con ese nombre.");
    }

    public Restaurant findByName(String name) {
        return restaurants.stream()
                .filter(restaurant -> restaurant.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public Restaurant deleteRestaurant(String name) {
        Restaurant restaurant = findByName(name);
        if (restaurant != null) {
            restaurants.remove(restaurant);
        }
        return restaurant;
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
