package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private String name;
    private String email;
    private List<Review> reviewsMade;

    public Users() {
        this.reviewsMade = new ArrayList<>();
    }

    public Users(String name, String email) {
        this.name = name;
        this.email = email;
        this.reviewsMade = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Review> getReviewsMade() {
        return reviewsMade;
    }

    public void addReview(Review review) {
        this.reviewsMade.add(review);
    }

    public String toString() {
        return "User: " + name + "\n" +
                "Email: " + email + "\n" +
                "Reviews Made: " + reviewsMade.size() + "\n";
    }
}
