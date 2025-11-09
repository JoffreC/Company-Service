package com.test.company_service.application.useCases.company;

import com.test.company_service.domain.ports.in.company.ValidateCompanyIdUseCase;
import com.test.company_service.domain.ports.out.company.CompanyRepositoryPort;
import lombok.RequiredArgsConstructor;

// Implementation
@RequiredArgsConstructor
public class ValidateCompanyIdUseCaseImpl implements ValidateCompanyIdUseCase {

    private final CompanyRepositoryPort companyRepositoryPort;

    @Override
    public Boolean validate(Long id) {
        return companyRepositoryPort.validate(id);
    }
}
