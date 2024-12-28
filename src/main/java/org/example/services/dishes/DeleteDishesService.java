package org.example.services.dishes;

import org.example.repositories.DishesRepository;
import org.example.utils.ConsoleHandler;

public class DeleteDishesService {
    private final DishesRepository repository;
    private final ConsoleHandler consoleHandler;

    public DeleteDishesService(DishesRepository repository, ConsoleHandler consoleHandler) {
        this.repository = repository;
        this.consoleHandler = consoleHandler;
    }

    public void deleteDishesExecute() {
        String name = consoleHandler.getString("Ingresa el nombre del plato que deseas eliminar: ");
        repository.deleteDishes(name);
    }
}
