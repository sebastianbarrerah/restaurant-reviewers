package org.example.services.dishes;

import org.example.models.Dishes;
import org.example.repositories.DishesRepository;

import java.util.List;

public class ShowDishesService {
    private final DishesRepository repository;

    public ShowDishesService(DishesRepository repository) {
        this.repository = repository;
    }

    public List<Dishes> showDishesExecute() {
        return repository.showDishes();
    }
}
