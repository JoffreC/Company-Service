package com.test.company_service.infrastructure.outbound.persistence.repositories.companyLocation;

import com.test.company_service.domain.models.CompanyLocation;
import com.test.company_service.domain.ports.out.companyLocation.CompanyLocationRepositoryPort;
import com.test.company_service.infrastructure.exceptions.ResourceNotFoundException;
import com.test.company_service.infrastructure.outbound.persistence.entities.CompanyEntity;
import com.test.company_service.infrastructure.outbound.persistence.entities.CompanyLocationEntity;
import com.test.company_service.infrastructure.outbound.persistence.repositories.company.JpaCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class JpaCompanyLocationRepositoryAdapter implements CompanyLocationRepositoryPort {

    private final JpaCompanyLocationRepository jpaCompanyLocationRepository;
    private final JpaCompanyRepository jpaCompanyRepository;

    @Override
    public CompanyLocation create(CompanyLocation companyLocation) {
        CompanyLocationEntity companyLocationEntity = CompanyLocationEntity.fromModel(companyLocation);
        CompanyEntity companyEntity = jpaCompanyRepository.findById(companyLocation.getCompanyId()).orElseThrow(() -> new ResourceNotFoundException("Company Not Found"));
        companyLocationEntity.setCompany(companyEntity);
        return jpaCompanyLocationRepository.save(companyLocationEntity).toModel();
    }

    @Override
    public List<CompanyLocation> createSeveral(List<CompanyLocation> companyLocations) {
        List<CompanyLocationEntity> companyLocationEntities = companyLocations.stream()
                .map(CompanyLocationEntity::fromModel)
                .toList();
        return jpaCompanyLocationRepository.saveAll(companyLocationEntities)
                .stream()
                .map(CompanyLocationEntity::toModel)
                .toList();
    }

    @Override
    public CompanyLocation retrieveById(Long id) {
        return jpaCompanyLocationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company Location not found"))
                .toModel();
    }

    @Override
    public List<CompanyLocation> retrieveAll() {
        return jpaCompanyLocationRepository.findAll()
                .stream()
                .map(CompanyLocationEntity::toModel)
                .toList();
    }

    @Override
    public CompanyLocation update(CompanyLocation companyLocation) {
        return jpaCompanyLocationRepository.findById(companyLocation.getId())
                .map(companyLocationEntity -> jpaCompanyLocationRepository.save(updateAttributes(companyLocationEntity, companyLocation)))
                .orElseThrow(() -> new ResourceNotFoundException("Company Location not found"))
                .toModel();
    }

    @Override
    public void delete(Long id) {
        jpaCompanyLocationRepository.deleteById(id);
    }

    private CompanyLocationEntity updateAttributes(CompanyLocationEntity companyLocationEntity, CompanyLocation companyLocation) {
        companyLocationEntity.setFirstAddress(companyLocation.getFirstAddress());
        companyLocationEntity.setSecondAddress(companyLocation.getSecondAddress());
        companyLocationEntity.setCity(companyLocation.getCity());
        companyLocationEntity.setProvince(companyLocation.getProvince());
        companyLocationEntity.setCountry(companyLocation.getCountry());
        if (!companyLocation.getCompanyId().equals(companyLocationEntity.getCompany().getId())) {
            companyLocationEntity.setCompany(jpaCompanyRepository.findById(companyLocation.getCompanyId()).orElseThrow(() -> new ResourceNotFoundException("Company Not Found")));
        }
        return companyLocationEntity;
    }
}
