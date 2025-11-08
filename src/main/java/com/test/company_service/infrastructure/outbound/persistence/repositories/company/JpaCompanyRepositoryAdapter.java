package com.test.company_service.infrastructure.outbound.persistence.repositories.company;

import com.test.company_service.domain.models.Company;
import com.test.company_service.domain.ports.out.company.CompanyRepositoryPort;
import com.test.company_service.infrastructure.exceptions.ResourceNotFoundException;
import com.test.company_service.infrastructure.outbound.persistence.entities.CompanyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class JpaCompanyRepositoryAdapter implements CompanyRepositoryPort {

    private final JpaCompanyRepository jpaCompanyRepository;

    @Override
    public Company create(Company company) {
        CompanyEntity companyEntity = CompanyEntity.fromModel(company);
        return jpaCompanyRepository.save(companyEntity).toModel();
    }

    @Override
    public Company retrieveById(Long id) {
        return jpaCompanyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found"))
                .toModel();
    }

    @Override
    public List<Company> retrieveAll() {
        return jpaCompanyRepository.findAll()
                .stream()
                .map(CompanyEntity::toModel)
                .toList();
    }

    @Override
    public Company update(Company company) {
        return jpaCompanyRepository.findById(company.getId())
                .map(companyEntity -> jpaCompanyRepository.save(updateAttributes(companyEntity, company)))
                .orElseThrow(() -> new ResourceNotFoundException("Company not found"))
                .toModel();
    }

    @Override
    public void delete(Long id) {
        jpaCompanyRepository.deleteById(id);
    }

    private CompanyEntity updateAttributes(CompanyEntity companyEntity, Company company) {
        companyEntity.setEmployerIdentificationNumber(company.getEmployerIdentificationNumber());
        companyEntity.setName(company.getName());
        companyEntity.setStructure(company.getStructure());
        companyEntity.setEmail(company.getEmail());
        companyEntity.setPhoneNumber(company.getPhoneNumber());
        companyEntity.setIsActive(company.getIsActive());
        return companyEntity;
    }
}
