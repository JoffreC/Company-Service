package com.test.company_service.infrastructure.inbound.controllers;

import com.test.company_service.application.services.CompanyLocationService;
import com.test.company_service.domain.models.CompanyLocation;
import com.test.company_service.infrastructure.dto.request.CreateCompanyLocationRequest;
import com.test.company_service.infrastructure.dto.request.UpdateCompanyLocationRequest;
import com.test.company_service.infrastructure.dto.response.ApiResponse;
import com.test.company_service.infrastructure.dto.response.CompanyLocationResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

// All company location endpoints
@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/location")
public class CompanyLocationController {

    private final CompanyLocationService companyLocationService;

    @Operation(summary = "Create company location", description = "Endpoint to create company locations")
    @PostMapping("create")
    public ResponseEntity<ApiResponse> create(@RequestBody CreateCompanyLocationRequest createCompanyLocationRequest) {
        CompanyLocation createdCompanyLocation = companyLocationService.create(createCompanyLocationRequest.toModel());
        URI uri = URI.create("/get-by-id/" + createdCompanyLocation.getId());
        return ResponseEntity.ok(new ApiResponse("Successfully created company location", createdCompanyLocation));
    }

    @Operation(summary = "Retrieve company location by id", description = "Endpoint to retrieve company location by its id")
    @GetMapping("get-by-id")
    public ResponseEntity<ApiResponse> getById(@RequestParam Long id) {
        CompanyLocation companyLocation = companyLocationService.retrieveById(id);
        CompanyLocationResponse companyLocationResponse = CompanyLocationResponse.fromModel(companyLocation);
        return ResponseEntity.ok(new ApiResponse("Successfully retrieved company location", companyLocationResponse));
    }

    @Operation(summary = "Retrieve company location by its company id", description = "Endpoint to retrieve company location by its company id")
    @GetMapping("get-by-company-id")
    public ResponseEntity<ApiResponse> getByCompanyId(@RequestParam Long companyId) {
        List<CompanyLocation> companyLocations = companyLocationService.retrieveByCompanyId(companyId);
        List<CompanyLocationResponse> companyLocationsResponse = companyLocations.stream().map(CompanyLocationResponse::fromModel).toList();
        return ResponseEntity.ok(new ApiResponse("Successfully retrieved company locations", companyLocationsResponse));
    }

    @Operation(summary = "Retrieve all companies locations", description = "Endpoint to retrieve all companies locations")
    @GetMapping("get-all")
    public ResponseEntity<ApiResponse> getAll() {
        List<CompanyLocation> companyLocations = companyLocationService.retrieveAll();
        List<CompanyLocationResponse> companyLocationsResponse = companyLocations.stream().map(CompanyLocationResponse::fromModel).toList();
        return ResponseEntity.ok(new ApiResponse("Successfully retrieved all company locations", companyLocationsResponse));
    }

    @Operation(summary = "Update company location", description = "Endpoint to update a company location")
    @PutMapping("update")
    public ResponseEntity<ApiResponse> update(@RequestBody UpdateCompanyLocationRequest updateCompanyLocationRequest) {
        CompanyLocation updatedCompanyLocation = companyLocationService.update(updateCompanyLocationRequest.toModel());
        return ResponseEntity.ok(new ApiResponse("Successfully updated company location", updatedCompanyLocation));
    }

    @Operation(summary = "Delete company location", description = "Endpoint to delete a company location")
    @DeleteMapping("delete")
    public ResponseEntity<ApiResponse> delete(@RequestParam Long id) {
        companyLocationService.delete(id);
        return ResponseEntity.ok(new ApiResponse("Successfully deleted company location", null));
    }
}
