package com.test.company_service.domain.ports.in.companyLocation;

import com.test.company_service.domain.models.CompanyLocation;

import java.util.List;

public interface RetrieveCompanyLocationUseCase {
    CompanyLocation retrieveById(Long id);
    List<CompanyLocation> retrieveAll();
}
