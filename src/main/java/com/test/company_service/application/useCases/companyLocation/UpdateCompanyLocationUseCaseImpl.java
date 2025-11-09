package com.test.company_service.application.useCases.companyLocation;

import com.test.company_service.domain.models.CompanyLocation;
import com.test.company_service.domain.ports.in.companyLocation.UpdateCompanyLocationUseCase;
import com.test.company_service.domain.ports.out.companyLocation.CompanyLocationRepositoryPort;
import lombok.RequiredArgsConstructor;

// Implementation
@RequiredArgsConstructor
public class UpdateCompanyLocationUseCaseImpl implements UpdateCompanyLocationUseCase {

    private final CompanyLocationRepositoryPort companyLocationRepositoryPort;

    @Override
    public CompanyLocation update(CompanyLocation companyLocation) {
        return companyLocationRepositoryPort.update(companyLocation);
    }
}
