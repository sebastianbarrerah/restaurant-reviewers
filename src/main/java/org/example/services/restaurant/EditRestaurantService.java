package org.example.services.restaurant;

import org.example.models.Restaurant;
import org.example.repositories.RestaurantRepository;
import org.example.utils.ConsoleHandler;

public class EditRestaurantService {

    private final RestaurantRepository repository;
    private final ConsoleHandler consoleHandler;

    public EditRestaurantService(RestaurantRepository repository, ConsoleHandler consoleHandler) {
        this.repository = repository;
        this.consoleHandler = consoleHandler;
    }

    public void editRestaurantExecute() {
        String name = consoleHandler.getString("Ingresa el nombre del restaurante que deseas editar: ");

        Restaurant restaurantToEdit = repository.showRestaurants().stream()
                .filter(restau -> restau.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (restaurantToEdit == null) {
            System.out.println("No se encontró un restaurante con ese nombre.");
            return;
        }

        String newCity = consoleHandler.getString("Ingresa la nueva ciudad del restaurante: ");
        String newDescription = consoleHandler.getString("Ingresa la nueva descripción del restaurante: ");
        String newName = consoleHandler.getString("Ingresa el nuevo nombre del restaurante: ");
        String newSchedule = consoleHandler.getString("Ingresa el nuevo horario del restaurante: ");

        repository.editRestaurant(name, newCity, newDescription, newName, newSchedule);
    }
}




