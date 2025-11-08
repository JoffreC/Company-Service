package com.test.company_service.infrastructure.outbound.persistence.entities;

import com.test.company_service.domain.models.Company;
import com.test.company_service.domain.models.CompanyStructure;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "company")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employerIdentificationNumber;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private CompanyStructure structure;

    private String email;

    private String phoneNumber;

    @Column(nullable = false)
    private Boolean isActive;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompanyLocationEntity> locations;

    public static CompanyEntity fromModel(Company company) {
        return CompanyEntity.builder()
                .id(company.getId())
                .employerIdentificationNumber(company.getEmployerIdentificationNumber())
                .name(company.getName())
                .structure(company.getStructure())
                .email(company.getEmail())
                .phoneNumber(company.getPhoneNumber())
                .isActive(company.getIsActive())
                .build();
    }

    public Company toModel() {
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
