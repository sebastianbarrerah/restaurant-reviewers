package org.example.services.menu;

import org.example.models.Dishes;
import org.example.models.Menu;
import org.example.repositories.DishesRepository;
import org.example.repositories.MenuRepository;
import org.example.utils.ConsoleHandler;

import java.util.ArrayList;
import java.util.List;

public class AddMenuService {

    private final MenuRepository repository;
    private final ConsoleHandler consoleHandler;
    private final DishesRepository dishesRepository;

    public AddMenuService(MenuRepository repository, ConsoleHandler consoleHandler, DishesRepository dishesRepository) {
        this.repository = repository;
        this.consoleHandler = consoleHandler;
        this.dishesRepository = dishesRepository;
    }

    public void addMenuExecute() {
        String name = consoleHandler.getString("Ingresa el nombre del menú: ");

        List<Dishes> allDishes = dishesRepository.showDishes();
        if (allDishes.isEmpty()) {
            System.out.println("No hay platos disponibles para añadir.");
            return;
        }

        System.out.println("Platos disponibles:");
        for (int i = 0; i < allDishes.size(); i++) {
            System.out.println((i + 1) + ". " + allDishes.get(i).getName());
        }

        List<Dishes> selectedDishes = new ArrayList<>();
        String input;
        do {
            input = consoleHandler.getString("Ingresa el número del plato que deseas añadir (o escribe 'fin' para terminar): ");
            if (!input.equalsIgnoreCase("fin")) {
                try {
                    int dishIndex = Integer.parseInt(input) - 1;
                    if (dishIndex >= 0 && dishIndex < allDishes.size()) {
                        selectedDishes.add(allDishes.get(dishIndex));
                        System.out.println("Plato añadido: " + allDishes.get(dishIndex).getName());
                    } else {
                        System.out.println("Número inválido. Intenta de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Intenta de nuevo.");
                }
            }
        } while (!input.equalsIgnoreCase("fin"));

        Menu menu = new Menu(name, selectedDishes);
        repository.addMenu(menu);

        System.out.println("Menú creado exitosamente con los siguientes platos:");
        selectedDishes.forEach(dish -> System.out.println("- " + dish.getName()));
    }
}
