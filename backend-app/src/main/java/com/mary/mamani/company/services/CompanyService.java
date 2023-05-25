package com.mary.mamani.company.services;

import com.mary.mamani.company.daos.Company;
import com.mary.mamani.company.repositories.ICompanyRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

  private final ICompanyRepository companyRepository;

  public Company createCompany(Company company) {
    if (companyRepository.existsByBusinessName(company.getBusinessName())) {
      throw new IllegalArgumentException("Ya existe una empresa con el mismo nombre");
    }

    if (companyRepository.existsByRuc(company.getRuc())) {
      throw new IllegalArgumentException("El RUC ya está ocupado por otra empresa");
    }

    return companyRepository.save(company);
  }

  public List<Company> getLastRecords(int quantityRecords) {
    PageRequest pageRequest = PageRequest.of(0, quantityRecords);
    return companyRepository.findLastRecords(pageRequest);
  }

  public List<Company> getAllCompanies() {
    return companyRepository.findAll();
  }
}
