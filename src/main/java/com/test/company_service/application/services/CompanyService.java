package com.test.company_service.application.services;

import com.test.company_service.domain.models.Company;
import com.test.company_service.domain.models.CompanyContact;
import com.test.company_service.domain.ports.in.company.*;
import com.test.company_service.domain.ports.in.companycontact.GetCompanyContactsUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

// Service to access all company use cases.
@RequiredArgsConstructor
public class CompanyService implements CreateCompanyUseCase, RetrieveCompanyUseCase, UpdateCompanyUseCase, DeleteCompanyUseCase, ValidateCompanyIdUseCase, GetCompanyContactsUseCase {

    private final CreateCompanyUseCase createCompanyUseCase;
    private final RetrieveCompanyUseCase retrieveCompanyUseCase;
    private final UpdateCompanyUseCase updateCompanyUseCase;
    private final DeleteCompanyUseCase deleteCompanyUseCase;
    private final ValidateCompanyIdUseCase validateCompanyIdUseCase;
    private final GetCompanyContactsUseCase getCompanyContactsUseCase;

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
        return updateCompanyUseCase.update(company);
    }

    @Override
    public Boolean validate(Long id) {
        return validateCompanyIdUseCase.validate(id);
    }

    @Override
    public List<CompanyContact> get(Long id) {
        return getCompanyContactsUseCase.get(id);
    }
}
