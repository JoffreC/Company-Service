package com.test.company_service.infrastructure.outbound.persistence.repositories.companyLocation;

import com.test.company_service.domain.models.CompanyLocation;
import com.test.company_service.infrastructure.outbound.persistence.entities.CompanyLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaCompanyLocationRepository extends JpaRepository<CompanyLocationEntity, Long> {
    List<CompanyLocationEntity> findByCompanyId(Long companyId);
}
