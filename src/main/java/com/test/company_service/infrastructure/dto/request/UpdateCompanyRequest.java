package com.test.company_service.infrastructure.dto.request;

import com.test.company_service.domain.models.Company;
import com.test.company_service.domain.models.CompanyStructure;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdateCompanyRequest {

    @NotNull(message = "Company id is required")
    private Long id;

    @Size(max = 10, message = "Size of number identification must not exceed 10 characters.")
    private String employerIdentificationNumber;

    @NotBlank(message = "Name of company is required.")
    @Size(max = 100, message = "Name must not exceed 100 characters.")
    private String name;

    @NotNull(message = "Structure is required.")
    private CompanyStructure structure;

    @Email(message = "Email is required")
    private String email;

    @Pattern(regexp = "^\\+?[0-9\\- ]{7,15}$", message = "Phone number have invalid format.")
    private String phoneNumber;

    @NotNull(message = "State is required.")
    private Boolean isActive;

    @NotEmpty(message = "At least one location is required.")
    private List<UpdateCompanyLocationRequest> locations;

    public Company toModel(){
        return Company.builder()
                .id(id)
                .employerIdentificationNumber(employerIdentificationNumber)
                .name(name)
                .structure(structure)
                .email(email)
                .phoneNumber(phoneNumber)
                .isActive(isActive)
                .build();
    }
}
