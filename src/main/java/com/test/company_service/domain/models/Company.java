package com.test.company_service.domain.models;

import lombok.Builder;
import lombok.Data;

// Domain model
@Data
@Builder
public class Company {
    private Long id;
    private String employerIdentificationNumber;
    private String name;
    private CompanyStructure structure;
    private String email;
    private String phoneNumber;
    private Boolean isActive;
}
