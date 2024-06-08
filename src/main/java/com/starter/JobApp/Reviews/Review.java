package com.starter.JobApp.Reviews;

import com.starter.JobApp.CompanyStructure.Company;
import jakarta.persistence.*;

@Entity
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    private Company company;
    private String description;

    public Review(){

    };

    public Review(Long reviewId, String description) {
        this.reviewId = reviewId;
        this.description = description;
    }

    public Company getCompany() {
        return company;
    };

    public void setCompany(Company company) {
        this.company = company;
    };

    public Long getId() {
        return reviewId;
    };

    public void setId(Long reviewId) {
        this.reviewId = reviewId;
    };

    public String getDescription() {
        return description;
    };

    public void setDescription(String description) {
        this.description = description;
    };
}
