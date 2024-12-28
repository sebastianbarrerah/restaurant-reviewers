package org.example.services.dishes;

import org.example.models.Dishes;
import org.example.repositories.DishesRepository;
import org.example.utils.ConsoleHandler;

public class AddDishesService {
    private final DishesRepository repository;
    private final ConsoleHandler consoleHandler;

    public AddDishesService(DishesRepository repository, ConsoleHandler consoleHandler) {
        this.repository = repository;
        this.consoleHandler = consoleHandler;
    }

    public void addDishesExecute() {
        String name = consoleHandler.getString("Ingresa el nombre del plato: ");
        String description = consoleHandler.getString("Ingresa la descripción del plato: ");
        Double price = consoleHandler.getDouble("Ingresa el precio del plato: ");
        String ingredients = consoleHandler.getString("Ingresa los ingredientes del plato separados por comas: ");
        Dishes nuevoPlato = new Dishes(name, description, price, ingredients);
        repository.addDishes(nuevoPlato);
    }
}
