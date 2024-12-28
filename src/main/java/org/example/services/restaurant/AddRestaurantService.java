package org.example.services.restaurant;

import org.example.models.Restaurant;
import org.example.repositories.RestaurantRepository;
import org.example.utils.ConsoleHandler;

public class AddRestaurantService {
    private final RestaurantRepository repository;
    private final ConsoleHandler consoleHandler;

    public AddRestaurantService(RestaurantRepository repository, ConsoleHandler consoleHandler) {
        this.repository = repository;
        this.consoleHandler = consoleHandler;
    }

    public void addRestaurantExecute() {
        String name = consoleHandler.getString("Ingresa el nombre del restaurante: ");
        String city = consoleHandler.getString("Ingresa la ciudad del restaurante: ");
        String description = consoleHandler.getString("Ingresa la descripción del restaurante: ");
        Restaurant restaurant = new Restaurant(name, city, description);
        repository.addRestaurant(restaurant);
    }

}
