package org.example.controllers.restaurant;

import org.example.services.restaurant.DeleteRestaurant;

public class DeleteRestaurantController {

    private final DeleteRestaurant deleteRestaurantService;

    public DeleteRestaurantController(DeleteRestaurant deleteRestaurantService) {
        this.deleteRestaurantService = deleteRestaurantService;
    }

    public void execute() {
        deleteRestaurantService.deleteRestaurantExecute();
    }
}
