package org.example.controllers.dishes;

import org.example.services.dishes.DeleteDishesService;

public class DeleteDishesController {

    private final DeleteDishesService deleteDishesService;

    public DeleteDishesController(DeleteDishesService deleteDishesService) {
        this.deleteDishesService = deleteDishesService;
    }

    public void execute() {
        try {
            deleteDishesService.deleteDishesExecute();
            System.out.println("platoe elikmido con éxito.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el plato.");
        }
    }
}
