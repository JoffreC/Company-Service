package com.test.company_service.domain.ports.out.company;

import com.test.company_service.domain.models.Company;

import java.util.List;

// Company port
public interface CompanyRepositoryPort {
    Company create(Company company);
    Company retrieveById(Long id);
    List<Company> retrieveAll();
    Company update(Company company);
    void delete(Long id);
    Boolean validate(Long id);
}
