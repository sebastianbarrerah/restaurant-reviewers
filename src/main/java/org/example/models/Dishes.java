package org.example.models;

import org.example.controllers.interfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Dishes {
    private String name;
    private String description;
    private Double price;
    private Double qualification;
    private String ingredients;
    private List<Review> reviews = new ArrayList<>();
    private List<IObserver> observers = new ArrayList<>();

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


    private void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(this.name, this.qualification);
        }
    }

    public void updateQualification() {
        double oldQualification = this.qualification;
        this.qualification = reviews.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);

        if (this.qualification != oldQualification) {
            notifyObservers();
        }
    }

    public void addReview(Review review) {
        this.reviews.add(review);
        updateQualification();
    }

    public String toString() {
        return "Dishes: " + this.name + "\n" +
                "Descripción: " + this.description + "\n" +
                "Precio: " + this.price + "\n" +
                "Ingredientes: " + this.ingredients + "\n" +
                "Qualificación: " + this.qualification + "\n";
    }
}
