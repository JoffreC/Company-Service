package com.test.company_service.domain.ports.out.companyLocation;

import com.test.company_service.domain.models.CompanyLocation;

import java.util.List;

public interface CompanyLocationRepositoryPort {
    CompanyLocation create(CompanyLocation companyLocation);
    List<CompanyLocation> createSeveral(List<CompanyLocation> companyLocations);
    CompanyLocation retrieveById(Long id);
    List<CompanyLocation> retrieveAll();
    CompanyLocation update(CompanyLocation companyLocation);
    void delete(Long id);
}
