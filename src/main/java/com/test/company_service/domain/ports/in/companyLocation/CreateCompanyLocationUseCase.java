package com.test.company_service.domain.ports.in.companyLocation;

import com.test.company_service.domain.models.CompanyLocation;

public interface CreateCompanyLocationUseCase {
    CompanyLocation create(CompanyLocation companyLocation);
}
