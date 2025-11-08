package com.test.company_service.infrastructure.outbound.persistence.repositories.company;

import com.test.company_service.infrastructure.outbound.persistence.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCompanyRepository extends JpaRepository<CompanyEntity, Long> {
}
