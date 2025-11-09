package com.test.company_service.domain.ports.in.companyLocation;

import com.test.company_service.domain.models.CompanyLocation;

import java.util.List;

// Retrieve Use Case
public interface RetrieveCompanyLocationUseCase {
    CompanyLocation retrieveById(Long id);
    List<CompanyLocation> retrieveByCompanyId(Long companyId);
    List<CompanyLocation> retrieveAll();
}
