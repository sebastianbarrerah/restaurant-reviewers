package org.example.controllers.restaurant;

import org.example.services.restaurant.AddRestaurantService;

public class AddRestaurantController {

    private final AddRestaurantService addRestaurant;

    public AddRestaurantController(AddRestaurantService addRestaurant) {
        this.addRestaurant = addRestaurant;
    }

    public void execute() {
        try {
            addRestaurant.addRestaurantExecute();
            System.out.println("Restaurante añadido con éxito.");
        } catch (Exception e) {
            System.out.println("Error al añadir el restaurante.");
        }
    }

}
