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

    @PutMapping
    public ResponseEntity<String> updateCompany(@RequestBody Company company){
        if(companyServiceImp.updateACompany(company))
        {
            return  new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Company Not found",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{companyId}")
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

    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long companyId)
    {
        if (companyServiceImp.deleteCompanyById(companyId))
        {
            return new ResponseEntity<>("company is removed from the portal",HttpStatus.OK);
        }
        return  new ResponseEntity<>("company does not exist/check company paramters again",HttpStatus.NOT_FOUND);
    }



}
