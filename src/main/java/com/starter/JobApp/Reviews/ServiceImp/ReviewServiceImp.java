package com.starter.JobApp.Reviews.ServiceImp;

import com.starter.JobApp.CompanyStructure.ServiceImp.CompanyServiceImp;
import com.starter.JobApp.Reviews.Review;
import com.starter.JobApp.Reviews.ReviewRepository;
import com.starter.JobApp.Reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService {

    public ReviewRepository reviewRepository;
    public CompanyServiceImp companyServiceImp;

    public ReviewServiceImp(ReviewRepository reviewRepository,CompanyServiceImp companyServiceImp) {
        this.reviewRepository = reviewRepository;
        this.companyServiceImp=companyServiceImp;
    }


    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Boolean postAReview(Review review) {
        if (review!= null && companyServiceImp.getCompanyWithID(review.getCompany().getCompanyID()).isPresent())
        {reviewRepository.save(review);
         return true;}
        return false;

    }

    @Override
    public String UpdateAReview( Review review)
    {
        if(reviewRepository.findById(review.getId()).isPresent())
        {   try
            {Review reviewPassed = reviewRepository.findById(review.getId()).orElse(null);
            reviewPassed.setCompany(review.getCompany());
            reviewPassed.setDescription(review.getDescription());
            reviewRepository.save(reviewPassed);
            return "true";
            }
            catch (Exception e)
            {

                return e.getMessage();

            }

        }
        return "false";
    }


}
