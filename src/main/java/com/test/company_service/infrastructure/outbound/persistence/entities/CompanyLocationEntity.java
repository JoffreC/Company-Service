package com.test.company_service.infrastructure.outbound.persistence.entities;

import com.test.company_service.domain.models.CompanyLocation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "company_locations")
public class CompanyLocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstAddress;

    private String secondAddress;

    private String city;

    private String province;

    private String country;

    @ManyToOne()
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    public static CompanyLocationEntity fromModel(CompanyLocation companyLocation) {
        return CompanyLocationEntity.builder()
                .id(companyLocation.getId())
                .firstAddress(companyLocation.getFirstAddress())
                .secondAddress(companyLocation.getSecondAddress())
                .city(companyLocation.getCity())
                .province(companyLocation.getProvince())
                .country(companyLocation.getCountry())
                .build();
    }

    public CompanyLocation toModel() {
        return CompanyLocation.builder()
                .id(id)
                .firstAddress(firstAddress)
                .secondAddress(secondAddress)
                .city(city)
                .province(province)
                .country(country)
                .companyId(company.getId())
                .build();
    }
}
