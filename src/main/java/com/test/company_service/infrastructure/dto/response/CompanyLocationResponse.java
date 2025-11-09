package com.test.company_service.infrastructure.dto.response;

import com.test.company_service.domain.models.CompanyLocation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyLocationResponse {
    private Long id;
    private String firstAddress;
    private String secondAddress;
    private String city;
    private String province;
    private String country;
    private Long companyId;

    public static CompanyLocationResponse fromModel(CompanyLocation companyLocation) {
        return CompanyLocationResponse.builder()
                .id(companyLocation.getId())
                .firstAddress(companyLocation.getFirstAddress())
                .secondAddress(companyLocation.getSecondAddress())
                .city(companyLocation.getCity())
                .province(companyLocation.getProvince())
                .country(companyLocation.getCountry())
                .companyId(companyLocation.getCompanyId())
                .build();
    }
}
