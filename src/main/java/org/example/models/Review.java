package org.example.models;

public abstract class Review {
    private final String userName;
    private final String comment;
    private final Double rating;

    public Review(String userName, String comment, Double rating) {
        this.userName = userName;
        this.comment = comment;
        this.rating = rating;
    }


    public String getUserName() {
        return userName;
    }

    public String getComment() {
        return comment;
    }

    public Double getRating() {
        return rating;
    }

    public abstract String showReview();
}
