package com.test.company_service.application.services;

import com.test.company_service.domain.models.CompanyLocation;
import com.test.company_service.domain.ports.in.companyLocation.CreateCompanyLocationUseCase;
import com.test.company_service.domain.ports.in.companyLocation.DeleteCompanyLocationUseCase;
import com.test.company_service.domain.ports.in.companyLocation.RetrieveCompanyLocationUseCase;
import com.test.company_service.domain.ports.in.companyLocation.UpdateCompanyLocationUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CompanyLocationService implements CreateCompanyLocationUseCase, RetrieveCompanyLocationUseCase, UpdateCompanyLocationUseCase, DeleteCompanyLocationUseCase {

    private final CreateCompanyLocationUseCase createCompanyLocationUseCase;
    private final RetrieveCompanyLocationUseCase retrieveCompanyLocationUseCase;
    private final UpdateCompanyLocationUseCase updateCompanyLocationUseCase;
    private final DeleteCompanyLocationUseCase deleteCompanyLocationUseCase;

    @Override
    public CompanyLocation create(CompanyLocation companyLocation) {
        return createCompanyLocationUseCase.create(companyLocation);
    }

    @Override
    public void delete(Long id) {
        deleteCompanyLocationUseCase.delete(id);
    }

    @Override
    public CompanyLocation retrieveById(Long id) {
        return retrieveCompanyLocationUseCase.retrieveById(id);
    }

    @Override
    public List<CompanyLocation> retrieveAll() {
        return retrieveCompanyLocationUseCase.retrieveAll();
    }

    @Override
    public CompanyLocation update(CompanyLocation companyLocation) {
        return updateCompanyLocationUseCase.update(companyLocation);
    }
}
