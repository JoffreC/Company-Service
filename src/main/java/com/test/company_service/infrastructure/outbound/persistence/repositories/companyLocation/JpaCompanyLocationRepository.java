package com.test.company_service.infrastructure.outbound.persistence.repositories.companyLocation;

import com.test.company_service.infrastructure.outbound.persistence.entities.CompanyLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCompanyLocationRepository extends JpaRepository<CompanyLocationEntity, Long> {
}
