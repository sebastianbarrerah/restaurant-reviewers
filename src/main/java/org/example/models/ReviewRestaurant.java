package org.example.models;

public class ReviewRestaurant extends Review {
    private final Integer service;
    private final Integer value;
    private final Integer location;
    private final Restaurant restaurant;

    public ReviewRestaurant(
            String userName,
            String comment,
            Double rating,
            Integer service,
            Integer value,
            Integer location,
            Restaurant restaurant
    ) {
        super(userName, comment, rating);
        this.service = service;
        this.value = value;
        this.location = location;
        this.restaurant = restaurant;
    }

    public Integer getService() {
        return service;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getLocation() {
        return location;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    @Override
    public String showReview() {
        return String.format("Reseña para Restaurante: %s\nUsuario: %s\nComentario: %s\nCalificación: %.1f\nServicio: %d\nValor: %d\nUbicación: %d",
                restaurant.getName(), getUserName(), getComment(), getRating(), service, value, location);
    }
}
