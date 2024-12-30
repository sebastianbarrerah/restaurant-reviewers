package org.example.controllers.review;

import org.example.services.review.ReviewService;

public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    public void executeReview() {
        reviewService.createReview();
    }
}

