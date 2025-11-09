package com.test.company_service.application.useCases.company;

import com.test.company_service.domain.models.Company;
import com.test.company_service.domain.ports.in.company.CreateCompanyUseCase;
import com.test.company_service.domain.ports.out.company.CompanyRepositoryPort;
import lombok.RequiredArgsConstructor;

// Implementation
@RequiredArgsConstructor
public class CreateCompanyUseCaseImpl implements CreateCompanyUseCase {

    private final CompanyRepositoryPort companyRepositoryPort;

    @Override
    public Company create(Company company) {
        return companyRepositoryPort.create(company);
    }
}
