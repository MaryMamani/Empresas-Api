package com.mary.mamani.company.controllers;

import com.mary.mamani.company.daos.Company;
import com.mary.mamani.company.services.CompanyService;
import com.mary.mamani.company.utils.constants.Endpoints;
import com.mary.mamani.company.utils.constants.Paths;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "javainuseapi")
@RequestMapping(Endpoints.COMPANY_ENDPOINT)
public class CompanyController {

  private final CompanyService companyService;

  @Operation(summary = "Registrar empresa")
  @ApiResponse(responseCode = "201", description = "Empresa Registrada")
  @PostMapping
  public ResponseEntity<Company> createCompany(@Valid @RequestBody Company company) {
    Company savedCompany = companyService.createCompany(company);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedCompany);
  }

  @Operation(summary = "Obtener los ultimos registros de la compañia")
  @ApiResponse(responseCode = "200", description = "Compañias encontradas")
  @GetMapping(Paths.Company.LAST_RECORDS)
  public ResponseEntity<List<Company>> getLastRecords(
      @RequestParam(defaultValue = "${company.quantityRecords.default}") int quantityRecords) {
    return ResponseEntity.ok(companyService.getLastRecords(quantityRecords));
  }

  @Operation(summary = "Obtener todas las compañias registradas")
  @ApiResponse(responseCode = "200", description = "Compañias encontradas")
  @ApiResponse(responseCode = "404", description = "No se encontraron compañias")
  @GetMapping
  public ResponseEntity<List<Company>> getAllCompanies() {
    List<Company> companies = companyService.getAllCompanies();
    if (companies.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(companies);
  }

}
