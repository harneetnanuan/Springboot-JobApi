package com.starter.JobApp.job.ServiceImplementation;

import com.starter.JobApp.job.Job;
import com.starter.JobApp.job.JobRepository;
import com.starter.JobApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class JobServiceImp implements JobService {

    JobRepository jobRepository;

    public  JobServiceImp(JobRepository jobRepository)
    {
        this.jobRepository = jobRepository;
    }

    //public List<Job> jobs = new ArrayList<Job>();
    //private long nextId= 1L;


    @Override
    public List<Job> getJobs()
    {
        return jobRepository.findAll();
    }

    @Override
    public void postJob(Job job)
    {

        //job.setId(this.nextId++);
        jobRepository.save(job);

    }

    @Override
    public Optional<Job> fetchJobByID(Long id)
    {
        return jobRepository.findById(id);

    }

    @Override
    public boolean updateJob(Long id, Job value)
    {
        Optional<Job> Optionaljob = jobRepository.findById(id);
                if(Optionaljob.isPresent())
                {           Job job = Optionaljob.get();
                            //job.setId(value.getId());
                            job.setLocation(value.getLocation());
                            job.setMinSalary(value.getMinSalary());
                            job.setMaxSalary(value.getMaxSalary());
                            job.setTitle(value.getTitle());
                            job.setDescription(value.getDescription());
                            jobRepository.save(job);
                            return true;
                }
                return false;
    }

    @Override
    public boolean deleteJob(Long id)
    {
            Optional<Job> optionalJob=jobRepository.findById(id);
                if(optionalJob.isPresent())
                {
                    Job job = optionalJob.get();
                    jobRepository.delete(job);
                    return true;
                }
                return false;
    }
}
