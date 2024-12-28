package org.example.controllers.dishes;

import org.example.models.Dishes;
import org.example.services.dishes.ShowDishesService;

import java.util.List;

public class ShowDishesController {
    private final ShowDishesService showDishesService;

    public ShowDishesController(ShowDishesService showDishesService) {
        this.showDishesService = showDishesService;
    }

    public void execute() {
        try {
            List<Dishes> dishesList = showDishesService.showDishesExecute();
            dishesList.forEach((item) -> System.out.println(item.toString()));
            System.out.println("Los platos que tienes:");
        } catch (Exception e) {
            System.out.println("Error al mostrar los platos.");
        }
    }
}
