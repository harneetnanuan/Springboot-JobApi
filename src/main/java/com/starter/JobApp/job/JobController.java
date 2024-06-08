package com.starter.JobApp.job;
import com.starter.JobApp.job.ServiceImplementation.JobServiceImp;
import com.starter.JobApp.CompanyStructure.ServiceImp.CompanyServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    public CompanyServiceImp companyServiceImp;
    public JobServiceImp jobServiceImp;

    JobController(JobServiceImp jobServiceImp, CompanyServiceImp companyServiceImp){
        this.jobServiceImp = jobServiceImp;
        this.companyServiceImp = companyServiceImp;
    }

    @GetMapping
    public ResponseEntity<List<Job>> getJobs(){

        return ResponseEntity.ok(jobServiceImp.getJobs());
    };

    @PostMapping
    public ResponseEntity<String> postJob(@RequestBody Job job ){
        if(job.getCompany()!=null)
        {
           if (companyServiceImp.getCompanyWithID(job.getCompany().getCompanyID()).isPresent())
                {   jobServiceImp.postJob(job);
                    return new ResponseEntity<>("Job Added",HttpStatus.CREATED);
                }
           else
                {
                    return new ResponseEntity<>("Company does not exist",HttpStatus.BAD_REQUEST);
                }
        }
        else
        {
            return new ResponseEntity<>("Every job must have a company",HttpStatus.BAD_REQUEST);
        }

    };

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Job>> getJobById(@PathVariable Long id){
        Optional<Job> job = jobServiceImp.fetchJobByID(id);
        if (job.isPresent())
         return new ResponseEntity<>(jobServiceImp.fetchJobByID(id), HttpStatus.OK);
        else
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    };

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job value){
        if (jobServiceImp.updateJob(id,value))
        {
            return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("no such job available.",HttpStatus.NOT_FOUND);
        }
    };

    @DeleteMapping("/removejob/{id}")
    public ResponseEntity<String> removeJob(@PathVariable Long id){
        if(jobServiceImp.deleteJob(id))
        {
            return new ResponseEntity<>("Job has been removed from the portal",HttpStatus.OK);

        }
        else
        {
            return new ResponseEntity<>("no such job available.",HttpStatus.NOT_FOUND);
        }
    };

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<Job>> getJobsByCompanyId(@PathVariable Long companyId){

        return new ResponseEntity<>(jobServiceImp.getJobsByCompanycompanyId(companyId),HttpStatus.OK);

    };
}
