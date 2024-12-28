package org.example.controllers.restaurant;

import org.example.models.Restaurant;
import org.example.services.restaurant.ShowRestaurantsService;

import java.util.List;

public class ShowRestaurantsController {

    private final ShowRestaurantsService showRestaurants;

    public ShowRestaurantsController(ShowRestaurantsService showRestaurants) {
        this.showRestaurants = showRestaurants;
    }

    public void execute() {
        try {
            List<Restaurant> restaurantList = showRestaurants.showRestaurantsExecute();
            restaurantList.forEach((item) -> System.out.println(item.toString()));
            System.out.println("Los restaurantes que tienes:");
        } catch (Exception e) {
            System.out.println("Error al mostrar los restaurantes.");
        }
    }

}
