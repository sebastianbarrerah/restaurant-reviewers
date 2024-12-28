package org.example.models;

public abstract class Review {
    private Users user;
    private String comment;
    private Double rating;

    public Review() {}

    public Review(Users user, String comment, Double rating) {
        this.user = user;
        this.comment = comment;
        this.rating = rating;
    }

    public abstract String showReview();

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }



}
