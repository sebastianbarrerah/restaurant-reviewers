package org.example;

import org.example.controllers.dishes.AddDishesController;
import org.example.controllers.dishes.DeleteDishesController;
import org.example.controllers.dishes.ShowDishesController;
import org.example.controllers.restaurant.AddRestaurantController;
import org.example.controllers.restaurant.DeleteRestaurantController;
import org.example.controllers.restaurant.EditRestaurantController;
import org.example.controllers.restaurant.ShowRestaurantsController;
import org.example.repositories.DishesRepository;
import org.example.repositories.RestaurantRepository;
import org.example.services.dishes.AddDishesService;
import org.example.services.dishes.DeleteDishesService;
import org.example.services.dishes.ShowDishesService;
import org.example.services.restaurant.AddRestaurantService;
import org.example.services.restaurant.DeleteRestaurant;
import org.example.services.restaurant.EditRestaurantService;
import org.example.services.restaurant.ShowRestaurantsService;
import org.example.utils.ConsoleHandler;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //Restaurante

        RestaurantRepository repository = RestaurantRepository.getInstance();
        ConsoleHandler consoleHandler = new ConsoleHandler();

        AddRestaurantService addRestaurantService = new AddRestaurantService(repository, consoleHandler);
        ShowRestaurantsService showRestaurantsService = new ShowRestaurantsService(repository);
        EditRestaurantService editRestaurantService = new EditRestaurantService(repository, consoleHandler);
        DeleteRestaurant deleteRestaurantService = new DeleteRestaurant(repository, consoleHandler);

        AddRestaurantController addRestaurantController = new AddRestaurantController(addRestaurantService);
        ShowRestaurantsController showRestaurantsController = new ShowRestaurantsController(showRestaurantsService);
        EditRestaurantController editRestaurantController = new EditRestaurantController(editRestaurantService);
        DeleteRestaurantController deleteRestaurantController = new DeleteRestaurantController(deleteRestaurantService);

        //Platos

        DishesRepository dishesRepository = DishesRepository.getInstance();
        AddDishesService addDishesService = new AddDishesService(dishesRepository, consoleHandler, consoleHandler);
        AddDishesController addDishesController = new AddDishesController(addDishesService);

        DeleteDishesService deleteDishesService = new DeleteDishesService(dishesRepository, consoleHandler);
        DeleteDishesController deleteDishesController = new DeleteDishesController(deleteDishesService);

        ShowDishesService showDishesService = new ShowDishesService(dishesRepository);
        ShowDishesController showDishesController = new ShowDishesController(showDishesService);


        // Map para asociar opciones con controladores
        Map<Integer, Runnable> controllers = Map.of(
                1, addRestaurantController::execute,
                2, showRestaurantsController::execute,
                3, editRestaurantController::executeController,
                4, deleteRestaurantController::execute,
                5, addDishesController::execute,
                6, deleteDishesController::execute,
                7, showDishesController::execute
        );

        // Menú principal
        int option;
        do {
            option = consoleHandler.getInteger("""
                    Bienvenido a la Gestión de Restaurantes.
                    ¿Qué deseas hacer?
                    1. Añadir un restaurante
                    2. Ver restaurantes
                    3. Editar un restaurante
                    4. eliminar un restaurante
                    5. agregar platos
                    6. eliminar platos
                    7. ver platos
                    8. Salir
                    """);

            if (controllers.containsKey(option)) {
                controllers.get(option).run();
            } else if (option != 8) {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (option != 8);

        System.out.println("Gracias por usar la aplicación. ¡Adiós!");
    }
}
