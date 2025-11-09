package com.test.company_service.domain.models;

import lombok.Builder;
import lombok.Data;

// Domain model
@Data
@Builder
public class CompanyLocation {
    private Long id;
    private String firstAddress;
    private String secondAddress;
    private String city;
    private String province;
    private String country;
    private Long companyId;
}
