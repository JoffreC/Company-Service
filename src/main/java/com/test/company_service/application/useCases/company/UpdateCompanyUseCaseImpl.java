package com.test.company_service.application.useCases.company;


import com.test.company_service.domain.models.Company;
import com.test.company_service.domain.ports.in.company.UpdateCompanyUseCase;
import com.test.company_service.domain.ports.out.company.CompanyRepositoryPort;
import lombok.RequiredArgsConstructor;

// Implementation
@RequiredArgsConstructor
public class UpdateCompanyUseCaseImpl implements UpdateCompanyUseCase {

    private final CompanyRepositoryPort companyRepositoryPort;

    @Override
    public Company update(Company company) {
        return companyRepositoryPort.update(company);
    }
}
