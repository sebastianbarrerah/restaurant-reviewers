package org.example.controllers.restaurant;

import org.example.services.restaurant.EditRestaurantService;

public class EditRestaurantController {

    private final EditRestaurantService editrestaurantService;

    public EditRestaurantController(EditRestaurantService editrestaurantService) {
        this.editrestaurantService = editrestaurantService;
    }

    public void executeController() {
        editrestaurantService.editRestaurantExecute();
        System.out.println("Restaurante editado con éxito.");
    }
}
