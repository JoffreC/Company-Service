package com.test.company_service.domain.ports.in.companycontact;

import com.test.company_service.domain.models.CompanyContact;

import java.util.List;

// Use case to get information of external service Contact Service
public interface GetCompanyContactsUseCase {
    List<CompanyContact> get(Long id);
}
