package com.starter.JobApp.Reviews;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reviewedCompany;
    private String reviewerName;
    private boolean Employee;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewedCompany() {
        return reviewedCompany;
    }

    public void setReviewedCompany(String reviewedCompany) {
        this.reviewedCompany = reviewedCompany;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public boolean isEmployee() {
        return Employee;
    }

    public void setEmployee(boolean employee) {
        Employee = employee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
