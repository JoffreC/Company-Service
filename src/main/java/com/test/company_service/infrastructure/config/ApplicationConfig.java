package com.test.company_service.infrastructure.config;

import com.test.company_service.application.services.CompanyLocationService;
import com.test.company_service.application.services.CompanyService;
import com.test.company_service.application.useCases.company.*;
import com.test.company_service.application.useCases.companyContact.GetCompanyContactsUseCaseImpl;
import com.test.company_service.application.useCases.companyLocation.CreateCompanyLocationUseCaseImpl;
import com.test.company_service.application.useCases.companyLocation.DeleteCompanyLocationUseCaseImpl;
import com.test.company_service.application.useCases.companyLocation.RetrieveCompanyLocationUseCaseImpl;
import com.test.company_service.application.useCases.companyLocation.UpdateCompanyLocationUseCaseImpl;
import com.test.company_service.domain.ports.in.companycontact.GetCompanyContactsUseCase;
import com.test.company_service.domain.ports.out.company.CompanyRepositoryPort;
import com.test.company_service.domain.ports.out.companyContact.CompanyContactRepositoryPort;
import com.test.company_service.domain.ports.out.companyLocation.CompanyLocationRepositoryPort;
import com.test.company_service.infrastructure.outbound.persistence.repositories.company.JpaCompanyRepositoryAdapter;
import com.test.company_service.infrastructure.outbound.persistence.repositories.companyLocation.JpaCompanyLocationRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Beans Configuration
@Configuration
public class ApplicationConfig {

    @Bean
    public CompanyService companyService(CompanyRepositoryPort companyRepositoryPort, GetCompanyContactsUseCase getCompanyContactsUseCase) {
        return new CompanyService(
                new CreateCompanyUseCaseImpl(companyRepositoryPort),
                new RetrieveCompanyUseCaseImpl(companyRepositoryPort),
                new UpdateCompanyUseCaseImpl(companyRepositoryPort),
                new DeleteCompanyUseCaseImpl(companyRepositoryPort),
                new ValidateCompanyIdUseCaseImpl(companyRepositoryPort),
                getCompanyContactsUseCase
        );
    }

    @Bean
    public CompanyRepositoryPort companyRepositoryPort(JpaCompanyRepositoryAdapter jpaCompanyRepositoryAdapter) {
        return jpaCompanyRepositoryAdapter;
    }

    @Bean
    public CompanyLocationService companyLocationService(CompanyLocationRepositoryPort companyLocationRepositoryPort) {
        return new CompanyLocationService(
                new CreateCompanyLocationUseCaseImpl(companyLocationRepositoryPort),
                new RetrieveCompanyLocationUseCaseImpl(companyLocationRepositoryPort),
                new UpdateCompanyLocationUseCaseImpl(companyLocationRepositoryPort),
                new DeleteCompanyLocationUseCaseImpl(companyLocationRepositoryPort)
        );
    }

    @Bean
    public CompanyLocationRepositoryPort companyLocationRepositoryPort(JpaCompanyLocationRepositoryAdapter jpaCompanyLocationRepositoryAdapter) {
        return jpaCompanyLocationRepositoryAdapter;
    }

    @Bean
    public GetCompanyContactsUseCase getCompanyContactsUseCase(CompanyContactRepositoryPort companyContactRepositoryPort) {
        return new GetCompanyContactsUseCaseImpl(companyContactRepositoryPort);
    }

}
