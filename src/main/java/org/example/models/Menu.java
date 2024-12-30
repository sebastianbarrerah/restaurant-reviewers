package org.example.models;

import java.util.List;

public class Menu {
    private String name;
    private List<Dishes> dishes;

    public Menu() {}

    public Menu(String name,  List<Dishes> dishes) {
        this.name = name;
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dishes> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dishes> dishes) {
        this.dishes = dishes;
    }

    public String toString() {
        return "Menu: " + this.name + "\n" +
                "Dishes: " + this.dishes.size() + "\n" +
                "Dishes: " + this.dishes.toString() + "\n" +
                "---------------------------------------------------\n";
    }
}
