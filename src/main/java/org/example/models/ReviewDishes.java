package org.example.models;

public class ReviewDishes extends Review {
    private final Integer flavor;
    private final Integer presentation;
    private final Integer service;
    private final Integer value;
    private final Dishes dish;

    public ReviewDishes(
            String userName,
            String comment,
            Double rating,
            Integer flavor,
            Integer presentation,
            Integer service,
            Integer value,
            Dishes dish
    ) {
        super(userName, comment, rating);
        this.flavor = flavor;
        this.presentation = presentation;
        this.service = service;
        this.value = value;
        this.dish = dish;
    }



    public Integer getFlavor() {
        return flavor;
    }

    public Integer getPresentation() {
        return presentation;
    }

    public Integer getService() {
        return service;
    }

    public Integer getValue() {
        return value;
    }

    public Dishes getDish() {
        return dish;
    }

    @Override
    public String showReview() {
        return String.format("Reseña para Plato: %s\nUsuario: %s\nComentario: %s\nCalificación: %.1f\nSabor: %d\nPresentación: %d\nServicio: %d\nValor: %d",
                dish.getName(), getUserName(), getComment(), getRating(), flavor, presentation, service, value);
    }

    public Dishes getDishes() {
        return dish;
    }
}
