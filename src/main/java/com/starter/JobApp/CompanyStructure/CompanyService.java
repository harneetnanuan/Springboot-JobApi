package com.starter.JobApp.CompanyStructure;

import com.starter.JobApp.job.Job;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    public List<Company> getAllCompanies();
    public void addACompany( Company company);
    public Boolean updateACompany(Company company);
    public Optional<Company> getCompanyWithID(Long companyId);
    public Boolean deleteCompanyById(Long companyId);
}
