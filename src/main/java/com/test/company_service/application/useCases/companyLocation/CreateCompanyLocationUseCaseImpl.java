package com.test.company_service.application.useCases.companyLocation;

import com.test.company_service.domain.models.CompanyLocation;
import com.test.company_service.domain.ports.in.companyLocation.CreateCompanyLocationUseCase;
import com.test.company_service.domain.ports.out.companyLocation.CompanyLocationRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CreateCompanyLocationUseCaseImpl implements CreateCompanyLocationUseCase {

    private final CompanyLocationRepositoryPort companyLocationRepositoryPort;

    @Override
    public CompanyLocation create(CompanyLocation companyLocation) {
        return companyLocationRepositoryPort.create(companyLocation);
    }

    @Override
    public List<CompanyLocation> createSeveral(List<CompanyLocation> companyLocations) {
        return companyLocationRepositoryPort.createSeveral(companyLocations);
    }
}
