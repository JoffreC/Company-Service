package com.test.company_service.infrastructure.dto.response;

import com.test.company_service.domain.models.Company;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EssentialInfoCompanyResponse {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Boolean isActive;

    public static EssentialInfoCompanyResponse fromModel(Company company) {
        return EssentialInfoCompanyResponse.builder()
                .id(company.getId())
                .name(company.getName())
                .email(company.getEmail())
                .phoneNumber(company.getPhoneNumber())
                .isActive(company.getIsActive())
                .build();
    }
}
