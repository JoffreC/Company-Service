package com.test.company_service.domain.ports.in.company;

// Validate id Use Case for external service use
public interface ValidateCompanyIdUseCase {
    Boolean validate(Long id);
}
