package com.test.company_service.application.useCases.companyContact;

import com.test.company_service.domain.models.CompanyContact;
import com.test.company_service.domain.ports.in.companycontact.GetCompanyContactsUseCase;
import com.test.company_service.domain.ports.out.companyContact.CompanyContactRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

// Implementation
@RequiredArgsConstructor
public class GetCompanyContactsUseCaseImpl implements GetCompanyContactsUseCase {

    private final CompanyContactRepositoryPort companyContactRepositoryPort;

    @Override
    public List<CompanyContact> get(Long id) {
        return companyContactRepositoryPort.get(id);
    }
}
