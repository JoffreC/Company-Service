package com.test.company_service.domain.ports.in.company;

import com.test.company_service.domain.models.Company;

import java.util.List;

public interface RetrieveCompanyUseCase {
    Company retrieveById(Long id);
    List<Company> retrieveAll();
}
