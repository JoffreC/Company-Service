package com.test.company_service.domain.ports.in.company;

import com.test.company_service.domain.models.Company;

public interface DeleteCompanyUseCase {
    void delete(Long id);
}
