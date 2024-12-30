package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Dishes {
    private String name;
    private String description;
    private Double price;
    private Double qualification;
    private String ingredients;
    private List<Review> reviews = new ArrayList<>();

    public Dishes() {}

    public Dishes(String name, String description, Double price, String ingredients) {
        this.name = name;
        this.price = price;
        this.qualification = qualification;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQualification() {
        return qualification;
    }

    public void setQualification(Double qualification) {
        this.qualification = qualification;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public String toString() {
        return "Dishes: " + this.name + "\n" +
                "Descripción: " + this.description + "\n" +
                "Precio: " + this.price + "\n" +
                "Ingredientes: " + this.ingredients + "\n" +
                "Qualificación: " + this.qualification + "\n";
    }
}
