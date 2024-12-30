package org.example.repositories;

import org.example.models.Dishes;

import java.util.ArrayList;
import java.util.List;

public class DishesRepository {
    private static DishesRepository instance;
    private List<Dishes> dishes;

    private DishesRepository() {
        dishes = new ArrayList<>();
    }

    public static DishesRepository getInstance() {
        if (instance == null) {
            instance = new DishesRepository();
        }
        return instance;
    }

    public void addDishes(Dishes dishes) {
        this.dishes.add(dishes);
    }

    public List<Dishes> showDishes() {
        return dishes;
    }

    public void deleteDishes(String name) {
        this.dishes.remove(findByName(name));
    }

    public Dishes findByName(String name) {
        return dishes.stream()
                .filter(dishes -> dishes.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
