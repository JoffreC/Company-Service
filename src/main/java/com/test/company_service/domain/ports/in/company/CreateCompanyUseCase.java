package com.test.company_service.domain.ports.in.company;

import com.test.company_service.domain.models.Company;

public interface CreateCompanyUseCase {
    Company create(Company company);
}
