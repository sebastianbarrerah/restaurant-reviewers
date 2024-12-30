import org.example.models.Users;

public abstract class Review {
    private Users user;
    private String comment;
    private Double rating;

    public Review(Users user, String comment, Double rating) {
        this.user = user;
        this.comment = comment;
        this.rating = rating;
    }

    public String showReview() {
        return String.format("Comentario: %s, Calificación: %.2f", comment, rating);
    }
}
