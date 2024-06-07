package com.starter.JobApp.CompanyStructure;

import com.starter.JobApp.job.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.starter.JobApp.CompanyStructure.ServiceImp.CompanyServiceImp;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    public CompanyService companyServiceImp;

    public CompanyController(CompanyService companyServiceImp)
    {
    this.companyServiceImp = companyServiceImp;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getListOfCompanies()
    {
    return new ResponseEntity<>(companyServiceImp.getAllCompanies(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addACompany(@RequestBody Company company)
    {   companyServiceImp.addACompany(company);
        return new ResponseEntity<>("added",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Company>> getCompanyById(@PathVariable Long companyId)
    {
        Optional<Company> companyOptional =companyServiceImp.getCompanyWithID(companyId);
        if(companyOptional.isPresent())
        {
            Optional<Company> company = Optional.of(companyOptional.get());
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Job>> getAllJobsInACompany(@PathVariable Long companyId){
        return new ResponseEntity<>(companyServiceImp.getAllJobsInACompany(companyId),HttpStatus.OK);
    }


}
