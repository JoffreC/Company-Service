package com.test.company_service.domain.ports.out.companyContact;

import com.test.company_service.domain.models.CompanyContact;

import java.util.List;

// External information port
public interface CompanyContactRepositoryPort {
    List<CompanyContact> get(Long id);
}
