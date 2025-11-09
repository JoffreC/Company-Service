package com.test.company_service.infrastructure.dto.request;

import com.test.company_service.domain.models.CompanyLocation;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateCompanyLocationRequest {

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

    public CompanyLocation toModel() {
        return CompanyLocation.builder()
                .firstAddress(firstAddress)
                .secondAddress(secondAddress)
                .city(city)
                .province(province)
                .country(country)
                .build();
    }
}
