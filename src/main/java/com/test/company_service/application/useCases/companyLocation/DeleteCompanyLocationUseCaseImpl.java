package com.test.company_service.application.useCases.companyLocation;

import com.test.company_service.domain.ports.in.companyLocation.DeleteCompanyLocationUseCase;
import com.test.company_service.domain.ports.out.companyLocation.CompanyLocationRepositoryPort;
import lombok.RequiredArgsConstructor;

// Implementation
@RequiredArgsConstructor
public class DeleteCompanyLocationUseCaseImpl implements DeleteCompanyLocationUseCase {

    private final CompanyLocationRepositoryPort companyLocationRepositoryPort;

    @Override
    public void delete(Long id) {
        companyLocationRepositoryPort.delete(id);
    }
}
