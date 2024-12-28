package org.example.controllers.dishes;

import org.example.services.dishes.AddDishesService;

public class AddDishesController {

    private final AddDishesService addDishesService;

    public AddDishesController(AddDishesService addDishesService) {
        this.addDishesService = addDishesService;
    }

    public void execute() {
        try {
            addDishesService.addDishesExecute();
            System.out.println("Restaurante añadido con éxito.");
        } catch (Exception e) {
            System.out.println("Error al añadir el plato.");
        }
    }


}
