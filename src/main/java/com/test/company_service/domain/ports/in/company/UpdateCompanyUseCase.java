package com.test.company_service.domain.ports.in.company;

import com.test.company_service.domain.models.Company;

// Update Use Case
public interface UpdateCompanyUseCase {
    Company update(Company company);
}
