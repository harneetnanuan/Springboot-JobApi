package com.starter.JobApp.job;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long > {
    List<Job> findBycompany_companyID(Long companyId);
}
