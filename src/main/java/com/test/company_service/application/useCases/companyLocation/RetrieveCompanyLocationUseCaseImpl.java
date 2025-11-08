package com.test.company_service.application.useCases.companyLocation;

import com.test.company_service.domain.models.CompanyLocation;
import com.test.company_service.domain.ports.in.companyLocation.RetrieveCompanyLocationUseCase;
import com.test.company_service.domain.ports.out.companyLocation.CompanyLocationRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RetrieveCompanyLocationUseCaseImpl implements RetrieveCompanyLocationUseCase {

    private final CompanyLocationRepositoryPort companyLocationRepositoryPort;

    @Override
    public CompanyLocation retrieveById(Long id) {
        return companyLocationRepositoryPort.retrieveById(id);
    }

    @Override
    public List<CompanyLocation> retrieveAll() {
        return companyLocationRepositoryPort.retrieveAll();
    }
}
