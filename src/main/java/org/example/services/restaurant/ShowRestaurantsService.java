package org.example.services.restaurant;

import org.example.models.Restaurant;
import org.example.repositories.RestaurantRepository;

import java.util.List;

public class ShowRestaurantsService {

    private final RestaurantRepository repository;

    public ShowRestaurantsService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public List<Restaurant> showRestaurantsExecute() {
        return repository.showRestaurants();
    }
}
