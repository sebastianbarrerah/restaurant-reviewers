package org.example.services.restaurant;

import org.example.models.Restaurant;
import org.example.repositories.RestaurantRepository;
import org.example.utils.ConsoleHandler;

public class DeleteRestaurant {

    private final RestaurantRepository repository;
    private final ConsoleHandler consoleHandler;

    public DeleteRestaurant(RestaurantRepository repository, ConsoleHandler consoleHandler) {
        this.repository = repository;
        this.consoleHandler = consoleHandler;
    }

    public void deleteRestaurantExecute() {
        String name = consoleHandler.getString("Ingresa el nombre del restaurante que deseas eliminar: ");
        Restaurant restaurant = repository.findByName(name);

        if (restaurant == null) {
            System.out.println("No se encontró un restaurante con ese nombre.");
            return;
        }

        if (!restaurant.getReviews().isEmpty()) {
            System.out.println("El restaurante " + restaurant.getName() + " no se puede eliminar porque tiene reviews.");
            return;
        }

        repository.deleteRestaurant(name);
        System.out.println("El restaurante " + restaurant.getName() + " ha sido eliminado con éxito.");
    }



}
