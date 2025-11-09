package com.test.company_service.infrastructure.inbound.controllers;

import com.test.company_service.application.services.CompanyLocationService;
import com.test.company_service.application.services.CompanyService;
import com.test.company_service.domain.models.Company;
import com.test.company_service.domain.models.CompanyLocation;
import com.test.company_service.infrastructure.dto.request.CreateCompanyLocationRequest;
import com.test.company_service.infrastructure.dto.request.CreateCompanyRequest;
import com.test.company_service.infrastructure.dto.request.UpdateCompanyLocationRequest;
import com.test.company_service.infrastructure.dto.request.UpdateCompanyRequest;
import com.test.company_service.infrastructure.dto.response.EssentialInfoCompanyResponse;
import com.test.company_service.infrastructure.dto.response.ApiResponse;
import com.test.company_service.infrastructure.dto.response.CompanyLocationResponse;
import com.test.company_service.infrastructure.dto.response.CompanyResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

// All company endpoints
@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/company")
public class CompanyController {

    private final CompanyService companyService;
    private final CompanyLocationService companyLocationService;

    @Operation(summary = "Create company", description = "Endpoint to create company with its locations")
    @PostMapping("create")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody CreateCompanyRequest createCompanyRequest) {
        Company createdCompany = companyService.create(createCompanyRequest.toModel());
        List<CreateCompanyLocationRequest> locations = createCompanyRequest.getLocations();
        List<CompanyLocationResponse> locationResponse = new ArrayList<>();
        for (CreateCompanyLocationRequest location : locations) {
            CompanyLocation companyLocation = location.toModel();
            companyLocation.setCompanyId(createdCompany.getId());
            companyLocation = companyLocationService.create(companyLocation);
            locationResponse.add(CompanyLocationResponse.fromModel(companyLocation));
        }
        CompanyResponse companyResponse = CompanyResponse.fromModel(createdCompany);
        companyResponse.setLocations(locationResponse);
        URI uri = URI.create("/get-by-id/" + createdCompany.getId());
        return ResponseEntity.created(uri).body(new ApiResponse("Successfully created createdCompany", companyResponse));
    }

    @Operation(summary = "Get company by id", description = "Endpoint to get a company by id")
    @GetMapping("get-by-id")
    public ResponseEntity<ApiResponse> getById(@RequestParam Long id) {
        Company company = companyService.retrieveById(id);
        List<CompanyLocation> locations = companyLocationService.retrieveByCompanyId(company.getId());
        CompanyResponse companyResponse = CompanyResponse.fromModel(company);
        companyResponse.setLocations(locations.stream().map(CompanyLocationResponse::fromModel).toList());
        companyResponse.setContacts(companyService.get(company.getId())); // get information in contact service
        return ResponseEntity.ok(new ApiResponse("Successfully retrieved company", companyResponse));
    }

    @Operation(summary = "Get essential info company by id", description = "Endpoint to get essential information company by id")
    @GetMapping("get-essential-info-by-id")
    public ResponseEntity<EssentialInfoCompanyResponse> getEssentialInfoById(@RequestParam Long id) {
        Company company = companyService.retrieveById(id);
        EssentialInfoCompanyResponse essentialInfoCompanyResponse = EssentialInfoCompanyResponse.fromModel(company);
        return ResponseEntity.ok(essentialInfoCompanyResponse);
    }

    @Operation(summary = "Get all companies", description = "Endpoint to get all companies")
    @GetMapping("get-all")
    public ResponseEntity<ApiResponse> getAll() {
        List<Company> companies = companyService.retrieveAll();
        List<EssentialInfoCompanyResponse> companiesResponse = companies.stream().map(EssentialInfoCompanyResponse::fromModel).toList();
        return ResponseEntity.ok(new ApiResponse("Successfully retrieved companies", companiesResponse));
    }

    @Operation(summary = "Update Company", description = "Endpoint to update a company")
    @PutMapping("update")
    public ResponseEntity<ApiResponse> update(@Valid @RequestBody UpdateCompanyRequest updateCompanyRequest) {

        Company company = companyService.update(updateCompanyRequest.toModel());
        List<UpdateCompanyLocationRequest> locations = updateCompanyRequest.getLocations();

        List<CompanyLocationResponse> locationResponse = new ArrayList<>();

        for (UpdateCompanyLocationRequest location : locations) {
            CompanyLocation companyLocation;
            if (location.getId() != null) {
                companyLocation = location.toModel();
                companyLocation = companyLocationService.update(companyLocation);
            } else {
                companyLocation = location.toNewModel();
                companyLocation = companyLocationService.create(companyLocation);
            }
            locationResponse.add(CompanyLocationResponse.fromModel(companyLocation));
        }

        CompanyResponse companyResponse = CompanyResponse.fromModel(company);
        companyResponse.setLocations(locationResponse);
        companyResponse.setContacts(companyService.get(company.getId()));
        return ResponseEntity.ok(new ApiResponse("Successfully updated company", companyResponse));
    }

    @Operation(summary = "Delete company", description = "Endpoint to delete a company")
    @DeleteMapping("delete")
    public ResponseEntity<ApiResponse> delete(@RequestParam("id") Long id) {
        companyService.delete(id);
        return ResponseEntity.ok(new ApiResponse("Successfully deleted company", null));
    }

    @Operation(summary = "Validate Id", description = "Endpoint to validate if a id exists")
    @GetMapping("validate")
    public ResponseEntity<Boolean> validateId(@RequestParam Long id) {
        return ResponseEntity.ok(companyService.validate(id));
    }
}
