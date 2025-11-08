package com.test.company_service.domain.ports.in.companyLocation;

import com.test.company_service.domain.models.CompanyLocation;

import java.util.List;

public interface CreateCompanyLocationUseCase {
    CompanyLocation create(CompanyLocation companyLocation);
    List<CompanyLocation> createSeveral(List<CompanyLocation> companyLocations);
}
