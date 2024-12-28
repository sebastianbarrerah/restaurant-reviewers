package org.example.models;

import java.util.List;

public class Dishes {
    private String name;
    private String description;
    private Double price;
    private List<Review> reviews;
    private List<Menu> menus;
    private Double qualification;
    private List<String> ingredients;


    public Dishes() {}

    public Dishes(String name, String description, Double price, List<Review> reviews, List<Menu> menus, Double qualification, List<String> ingredients) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.reviews = reviews;
        this.menus = menus;
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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Double getQualification() {
        return qualification;
    }

    public void setQualification(Double qualification) {
        this.qualification = qualification;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
