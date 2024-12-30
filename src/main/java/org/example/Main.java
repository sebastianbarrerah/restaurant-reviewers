package org.example;

import org.example.controllers.dishes.AddDishesController;
import org.example.controllers.dishes.DeleteDishesController;
import org.example.controllers.dishes.ShowDishesController;
import org.example.controllers.menu.AddMenuController;
import org.example.controllers.menu.DeleteMenuController;
import org.example.controllers.menu.EditMenuController;
import org.example.controllers.menu.ShowMenuController;
import org.example.controllers.restaurant.AddRestaurantController;
import org.example.controllers.restaurant.DeleteRestaurantController;
import org.example.controllers.restaurant.EditRestaurantController;
import org.example.controllers.restaurant.ShowRestaurantsController;
import org.example.controllers.review.ReviewController;
import org.example.controllers.user.AddUserController;
import org.example.models.ReviewFactory;
import org.example.repositories.DishesRepository;
import org.example.repositories.MenuRepository;
import org.example.repositories.RestaurantRepository;
import org.example.repositories.ReviewRepository;
import org.example.repositories.UsersRepository;
import org.example.services.dishes.AddDishesService;
import org.example.services.dishes.DeleteDishesService;
import org.example.services.dishes.ShowDishesService;
import org.example.services.menu.AddMenuService;
import org.example.services.menu.DeleteMenuService;
import org.example.services.menu.EditMenuService;
import org.example.services.menu.ShowMenuService;
import org.example.services.restaurant.AddRestaurantService;
import org.example.services.restaurant.DeleteRestaurant;
import org.example.services.restaurant.EditRestaurantService;
import org.example.services.restaurant.ShowRestaurantsService;
import org.example.services.review.ReviewService;
import org.example.utils.ConsoleHandler;
import org.example.utils.ConsoleObserver;

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
        AddDishesService addDishesService = new AddDishesService(dishesRepository, consoleHandler);
        AddDishesController addDishesController = new AddDishesController(addDishesService);

        DeleteDishesService deleteDishesService = new DeleteDishesService(dishesRepository, consoleHandler);
        DeleteDishesController deleteDishesController = new DeleteDishesController(deleteDishesService);

        ShowDishesService showDishesService = new ShowDishesService(dishesRepository);
        ShowDishesController showDishesController = new ShowDishesController(showDishesService);

        // Menús
        MenuRepository menuRepository = MenuRepository.getInstance();
        AddMenuService addMenuService = new AddMenuService(menuRepository, consoleHandler, dishesRepository);
        AddMenuController addMenuController = new AddMenuController(addMenuService);

        ShowMenuService showMenuService = new ShowMenuService(menuRepository);
        ShowMenuController showMenuController = new ShowMenuController(showMenuService);

        EditMenuService editMenuService = new EditMenuService(menuRepository, consoleHandler);
        EditMenuController editMenuController = new EditMenuController(editMenuService);

        DeleteMenuService deleteMenuService = new DeleteMenuService(menuRepository, consoleHandler);
        DeleteMenuController deleteMenuController = new DeleteMenuController(deleteMenuService);

        // Observer
        ConsoleObserver consoleObserver = new ConsoleObserver();

        //users
        UsersRepository userRepository = UsersRepository.getInstance();

        //reviews
        ReviewFactory reviewFactory = new ReviewFactory();
        ReviewRepository reviewRepository = ReviewRepository.getInstance();
        ReviewService reviewService = new ReviewService(
                repository,
                dishesRepository,
                reviewRepository,
                consoleHandler,
                reviewFactory
        );
        ReviewController addReviewController = new ReviewController(reviewService);


        Map<Integer, Runnable> controllers = Map.of(
                1, addRestaurantController::execute,
                2, showRestaurantsController::execute,
                3, editRestaurantController::executeController,
                4, deleteRestaurantController::execute,
                5, addDishesController::execute,
                6, deleteDishesController::execute,
                7, showDishesController::execute,
                8, addMenuController::execute,
                11, showMenuController::execute,
                12, addReviewController::executeReview
        );

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
                    8. Añadir menú
                    9. Salir
                    11. Ver menús
                    12. Añadir reseña
                    """);

            if (controllers.containsKey(option)) {
                controllers.get(option).run();
            } else if (option != 13) {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (option != 13);

        System.out.println("Gracias por usar la aplicación. ¡Adiós!");
    }
}
