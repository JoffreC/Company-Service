package com.test.company_service.infrastructure.dto.request;

import com.test.company_service.domain.models.Company;
import com.test.company_service.domain.models.CompanyStructure;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class CreateCompanyRequest {
    @Size(max = 10, message = "Size of number identification must not exceed 10 characters.")
    private String employerIdentificationNumber;

    @NotBlank(message = "Name of company is required.")
    @Size(max = 100, message = "Name must not exceed 100 characters.")
    private String name;

    private CompanyStructure structure;

    @Email(message = "Email is required")
    private String email;

    @Pattern(regexp = "^\\+?[0-9\\- ]{7,15}$", message = "Phone number have invalid format.")
    private String phoneNumber;

    @NotNull(message = "State is required.")
    private Boolean isActive;

    @NotEmpty(message = "At least one location is required.")
    private List<CreateCompanyLocationRequest> locations;

    public Company toModel(){
        return Company.builder()
                .employerIdentificationNumber(employerIdentificationNumber)
                .name(name)
                .structure(structure)
                .email(email)
                .phoneNumber(phoneNumber)
                .isActive(isActive)
                .build();
    }
}