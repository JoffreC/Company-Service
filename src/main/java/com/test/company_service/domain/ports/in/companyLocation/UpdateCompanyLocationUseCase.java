package com.test.company_service.domain.ports.in.companyLocation;

import com.test.company_service.domain.models.Company;
import com.test.company_service.domain.models.CompanyLocation;

// Update Use Case
public interface UpdateCompanyLocationUseCase {
    CompanyLocation update(CompanyLocation companyLocation);
}
