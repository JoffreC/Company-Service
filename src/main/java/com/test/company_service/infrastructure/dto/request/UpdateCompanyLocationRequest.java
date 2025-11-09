package com.test.company_service.infrastructure.dto.request;

import com.test.company_service.domain.models.CompanyLocation;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateCompanyLocationRequest {

    private Long id;

    @Size(max = 50, message = "Size of first address must not exceed 50 characters.")
    private String firstAddress;

    @Size(max = 50, message = "Size of second address must not exceed 50 characters.")
    private String secondAddress;

    @Size(max = 50, message = "Size of city must not exceed 50 characters.")
    private String city;

    @Size(max = 50, message = "Size of province must not exceed 50 characters.")
    private String province;

    @Size(max = 50, message = "Size of country must not exceed 50 characters.")
    private String country;

    @NotNull(message = "Company Id is required")
    private Long companyId;

    public CompanyLocation toModel() {
        return CompanyLocation.builder()
                .id(id)
                .firstAddress(firstAddress)
                .secondAddress(secondAddress)
                .city(city)
                .province(province)
                .country(country)
                .companyId(companyId)
                .build();
    }

    public CompanyLocation toNewModel() {
        return CompanyLocation.builder()
                .firstAddress(firstAddress)
                .secondAddress(secondAddress)
                .city(city)
                .province(province)
                .country(country)
                .companyId(companyId)
                .build();
    }
}
