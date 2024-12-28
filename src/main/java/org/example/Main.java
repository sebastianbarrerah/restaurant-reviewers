package org.example;

import org.example.controllers.restaurant.AddRestaurantController;
import org.example.controllers.restaurant.ShowRestaurantsController;
import org.example.repositories.RestaurantRepository;
import org.example.services.restaurant.AddRestaurantService;
import org.example.services.restaurant.ShowRestaurantsService;
import org.example.utils.ConsoleHandler;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Instancias necesarias
        RestaurantRepository repository = RestaurantRepository.getInstance();
        ConsoleHandler consoleHandler = new ConsoleHandler();

        // Servicios y controladores
        AddRestaurantService addRestaurantService = new AddRestaurantService(repository, consoleHandler);
        ShowRestaurantsService showRestaurantsService = new ShowRestaurantsService(repository);

        AddRestaurantController addRestaurantController = new AddRestaurantController(addRestaurantService);
        ShowRestaurantsController showRestaurantsController = new ShowRestaurantsController(showRestaurantsService);

        // Map para asociar opciones con controladores
        Map<Integer, Runnable> controllers = Map.of(
                1, addRestaurantController::execute,
                2, showRestaurantsController::execute
        );

        // Menú principal
        int option;
        do {
            option = consoleHandler.getInteger("""
                    Bienvenido a la Gestión de Restaurantes.
                    ¿Qué deseas hacer?
                    1. Añadir un restaurante
                    2. Ver restaurantes
                    3. Eliminar un restaurante
                    4. Salir
                    """);

            // Ejecutar la opción seleccionada
            if (controllers.containsKey(option)) {
                controllers.get(option).run();
            } else if (option != 4) {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (option != 4);

        System.out.println("Gracias por usar la aplicación. ¡Adiós!");
    }
}
