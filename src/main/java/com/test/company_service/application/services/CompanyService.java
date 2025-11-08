package com.test.company_service.application.services;

import com.test.company_service.domain.models.Company;
import com.test.company_service.domain.ports.in.company.CreateCompanyUseCase;
import com.test.company_service.domain.ports.in.company.DeleteCompanyUseCase;
import com.test.company_service.domain.ports.in.company.RetrieveCompanyUseCase;
import com.test.company_service.domain.ports.in.company.UpdateCompanyUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CompanyService implements CreateCompanyUseCase, RetrieveCompanyUseCase, UpdateCompanyUseCase, DeleteCompanyUseCase {

    private final CreateCompanyUseCase createCompanyUseCase;
    private final RetrieveCompanyUseCase retrieveCompanyUseCase;
    private final UpdateCompanyUseCase updateCompanyUseCase;
    private final DeleteCompanyUseCase deleteCompanyUseCase;

    @Override
    public Company create(Company company) {
        return createCompanyUseCase.create(company);
    }

    @Override
    public void delete(Long id) {
        deleteCompanyUseCase.delete(id);
    }

    @Override
    public Company retrieveById(Long id) {
        return retrieveCompanyUseCase.retrieveById(id);
    }

    @Override
    public List<Company> retrieveAll() {
        return retrieveCompanyUseCase.retrieveAll();
    }

    @Override
    public Company update(Company company) {
        return null;
    }
}
