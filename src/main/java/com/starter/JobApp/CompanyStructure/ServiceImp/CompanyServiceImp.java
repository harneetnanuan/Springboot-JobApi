package com.starter.JobApp.CompanyStructure.ServiceImp;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.starter.JobApp.CompanyStructure.Company;
import com.starter.JobApp.CompanyStructure.CompanyRepository;
import com.starter.JobApp.CompanyStructure.CompanyService;
import com.starter.JobApp.Reviews.Review;
import com.starter.JobApp.job.Job;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
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

    @Override
    public Boolean updateACompany(Company company) {
        Optional<Company> companyOptional =companyRepository.findById(company.getCompanyID());
        if (companyOptional.isPresent())
        {
            Company companypassed = companyOptional.get();
            companypassed.setCompanyName(company.getCompanyName());
            companypassed.setCompanyLocation(company.getCompanyLocation());
            companypassed.setCompanyType(company.getCompanyType());
            companyRepository.save(companypassed);
            return true;
        }
        return false;
    }

    public Optional<Company> getCompanyWithID(Long companyId){
        return companyRepository.findById(companyId);
    }

    public Boolean deleteCompanyById(Long companyId){
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        if(optionalCompany.isPresent())
        {   Company optionalCompany1 = optionalCompany.get();
            try{
                    companyRepository.delete(optionalCompany1);
                }
            catch (Exception e){
                 return false;
            }

            return true;
        }
        return false;
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
