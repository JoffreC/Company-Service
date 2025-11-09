package com.test.company_service.infrastructure.outbound.external;

import com.test.company_service.domain.models.CompanyContact;
import com.test.company_service.domain.ports.out.companyContact.CompanyContactRepositoryPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class CompanyContactRestClient implements CompanyContactRepositoryPort {

    private final WebClient webClient;

    public CompanyContactRestClient(WebClient.Builder builder,
                                    @Value("${contact.service.url}") String baseUrl) {
        this.webClient = builder.baseUrl(baseUrl).build();
    }

    // External service port use cases implementation
    // Get external information
    @Override
    public List<CompanyContact> get(Long id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/get-by-company-id")
                        .queryParam("companyId", id)
                        .build()
                )
                .retrieve()
                .bodyToFlux(CompanyContact.class)
                .collectList()
                .block();
    }
}
