package com.starter.JobApp.Reviews;

import java.util.List;

public interface ReviewService {

    // get all reviews
    public List<Review> getAllReviews();
    // post a review
    public Boolean postAReview(Review review);
    // update a review
    public String UpdateAReview( Review review);
    // get review by companyid, review id
    // get all reviews for a company id
    // delete a review by review id
}
