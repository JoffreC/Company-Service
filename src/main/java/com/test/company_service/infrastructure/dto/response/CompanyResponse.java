package com.test.company_service.infrastructure.dto.response;

import com.test.company_service.domain.models.Company;
import com.test.company_service.domain.models.CompanyContact;
import com.test.company_service.domain.models.CompanyStructure;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CompanyResponse {
    private Long id;
    private String employerIdentificationNumber;
    private String name;
    private CompanyStructure structure;
    private String email;
    private String phoneNumber;
    private List<CompanyLocationResponse> locations;
    private List<CompanyContact> contacts;
    private Boolean isActive;

    public static CompanyResponse fromModel(Company company) {
        return CompanyResponse.builder()
                .id(company.getId())
                .employerIdentificationNumber(company.getEmployerIdentificationNumber())
                .name(company.getName())
                .structure(company.getStructure())
                .email(company.getEmail())
                .phoneNumber(company.getPhoneNumber())
                .isActive(company.getIsActive())
                .build();
    }
}
