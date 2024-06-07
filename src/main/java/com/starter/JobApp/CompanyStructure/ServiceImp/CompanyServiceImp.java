package com.starter.JobApp.CompanyStructure.ServiceImp;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.starter.JobApp.CompanyStructure.Company;
import com.starter.JobApp.CompanyStructure.CompanyRepository;
import com.starter.JobApp.CompanyStructure.CompanyService;
import com.starter.JobApp.Reviews.Review;
import com.starter.JobApp.job.Job;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompanyServiceImp implements CompanyService {

     CompanyRepository companyRepository;

    public CompanyServiceImp(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies()
    {
        return companyRepository.findAll();
    }

    public void addACompany( Company company){
        companyRepository.save(company);
    }

    public Optional<Company> getCompanyWithID(Long companyId){
        return companyRepository.findById(companyId);
    }

    //get all jobs
//    public List<Job> getAllJobsInACompany(Long id){
//       Optional<List<Job>> optionalJobs = .findById(id);
//    }

//    // getallreviews for a companyID
//    public List<Review> getAllReview(Long companyId){
//         companyRepository.findById(companyId);
//         companyRepository.
//    }
//

    // get a particular review for a particular company
    // delete a particular review for a company id
    // delete a company

}
