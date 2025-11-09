package com.test.company_service.application.useCases.company;

import com.test.company_service.domain.ports.in.company.DeleteCompanyUseCase;
import com.test.company_service.domain.ports.out.company.CompanyRepositoryPort;
import lombok.RequiredArgsConstructor;

// Implementation
@RequiredArgsConstructor
public class DeleteCompanyUseCaseImpl implements DeleteCompanyUseCase {

    private final CompanyRepositoryPort companyRepositoryPort;

    @Override
    public void delete(Long id) {
        companyRepositoryPort.delete(id);
    }
}
