package org.example.models;

import java.util.List;

public class Menu {
    private String name;
    private Restaurant restaurant;
    private List<Dishes> dishes;

    public Menu() {}

    public Menu(String name, Restaurant restaurant, List<Dishes> dishes) {
        this.name = name;
        this.restaurant = restaurant;
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Dishes> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dishes> dishes) {
        this.dishes = dishes;
    }
}
