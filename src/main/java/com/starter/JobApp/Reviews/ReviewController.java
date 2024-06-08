package com.starter.JobApp.Reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    public ReviewService reviewServiceImp;

    public ReviewController(ReviewService reviewService) {
        this.reviewServiceImp = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        return new ResponseEntity<>(reviewServiceImp.getAllReviews(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> postAReview(@RequestBody Review review){
        if(reviewServiceImp.postAReview(review))
        {
            return new ResponseEntity<>("review posted.", HttpStatus.CREATED);
        }
        else return new ResponseEntity<>("review must have a body and a company", HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<String> updateReview(@RequestBody Review review){
        if(reviewServiceImp.UpdateAReview(review).equals("true"))
        {
            return new ResponseEntity<>("Review Update",HttpStatus.OK);
        }
        else if(reviewServiceImp.UpdateAReview(review).equals("false"))
        {
            return new ResponseEntity<>("Please check id",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reviewServiceImp.UpdateAReview(review),HttpStatus.BAD_REQUEST);

    }
}
