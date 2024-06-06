package com.starter.JobApp.job;

import java.util.List;
import java.util.Optional;

public interface JobService {

    public List<Job> getJobs();

    public void postJob(Job job);

    public Optional<Job>  fetchJobByID(Long Id);

    public boolean updateJob(Long id, Job value);

    public boolean deleteJob(Long id);
}
