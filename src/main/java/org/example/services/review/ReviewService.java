package org.example.services.review;

import org.example.constants.ReviewType;
import org.example.models.*;
import org.example.repositories.ReviewRepository;
import org.example.repositories.RestaurantRepository;
import org.example.repositories.DishesRepository;
import org.example.repositories.UsersRepository;
import org.example.utils.ConsoleHandler;

public class ReviewService {
    private final RestaurantRepository restaurantRepository;
    private final DishesRepository dishesRepository;
    private final UsersRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final ConsoleHandler consoleHandler;

    public ReviewService(
            RestaurantRepository restaurantRepository,
            DishesRepository dishesRepository,
            UsersRepository userRepository,
            ReviewRepository reviewRepository,
            ConsoleHandler consoleHandler
    ) {
        this.restaurantRepository = restaurantRepository;
        this.dishesRepository = dishesRepository;
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
        this.consoleHandler = consoleHandler;
    }

    public void createReview() {
        // Pedir tipo de review
        String type = consoleHandler.getString("¿Qué deseas calificar? (restaurant/dish): ").toLowerCase();

        // Pedir datos comunes
        String userName = consoleHandler.getString("Ingresa tu nombre de usuario: ");
        Users user = userRepository.findByName(userName);

        if (user == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        String comment = consoleHandler.getString("Ingresa tu comentario: ");
        Double rating = consoleHandler.getDouble("Ingresa tu calificación (0-5): ");
        Review review = null;

        if (type.equals("restaurant")) {
            review = createRestaurantReview(user, comment, rating);
        } else if (type.equals("dish")) {
            review = createDishReview(user, comment, rating);
        } else {
            System.out.println("Tipo de review inválido.");
            return;
        }

        if (review != null) {
            reviewRepository.addReview(review);
            System.out.println("¡Review creada con éxito!");
            System.out.println(review.showReview());
        }
    }

    private ReviewRestaurant createRestaurantReview(Users user, String comment, Double rating) {
        String restaurantName = consoleHandler.getString("Ingresa el nombre del restaurante: ");
        Restaurant restaurant = restaurantRepository.findByName(restaurantName);

        if (restaurant == null) {
            System.out.println("Restaurante no encontrado.");
            return null;
        }

        Integer service = consoleHandler.getInteger("Calificación de servicio (0-5): ");
        Integer value = consoleHandler.getInteger("Calificación de valor (0-5): ");
        Integer location = consoleHandler.getInteger("Calificación de ubicación (0-5): ");

        return ReviewFactory.createReview(
                ReviewType.RESTAURANT,
                user,
                comment,
                rating,
                null, // flavor
                null, // presentation
                service,
                value,
                null, // dishes
                location,
                restaurant
        );
    }

    private ReviewDishes createDishReview(Users user, String comment, Double rating) {
        String dishName = consoleHandler.getString("Ingresa el nombre del plato: ");
        Dishes dish = dishesRepository.findByName(dishName);

        if (dish == null) {
            System.out.println("Plato no encontrado.");
            return null;
        }

        Integer flavor = consoleHandler.getInteger("Calificación de sabor (0-5): ");
        Integer presentation = consoleHandler.getInteger("Calificación de presentación (0-5): ");
        Integer service = consoleHandler.getInteger("Calificación de servicio (0-5): ");
        Integer value = consoleHandler.getInteger("Calificación de valor (0-5): ");

        return ReviewFactory.createReview(
                ReviewType.DISH,
                user,
                comment,
                rating,
                flavor,
                presentation,
                service,
                value,
                dish,
                null, // location
                null  // restaurant
        );
    }
}
