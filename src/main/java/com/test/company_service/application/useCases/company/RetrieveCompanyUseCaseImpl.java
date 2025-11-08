package com.test.company_service.application.useCases.company;

import com.test.company_service.domain.models.Company;
import com.test.company_service.domain.ports.in.company.RetrieveCompanyUseCase;
import com.test.company_service.domain.ports.out.company.CompanyRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RetrieveCompanyUseCaseImpl implements RetrieveCompanyUseCase {

    private final CompanyRepositoryPort companyRepositoryPort;

    @Override
    public Company retrieveById(Long id) {
        return companyRepositoryPort.retrieveById(id);
    }

    @Override
    public List<Company> retrieveAll() {
        return companyRepositoryPort.retrieveAll();
    }
}
