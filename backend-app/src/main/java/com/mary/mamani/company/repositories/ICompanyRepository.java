package com.mary.mamani.company.repositories;

import com.mary.mamani.company.daos.Company;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, Long> {

  boolean existsByBusinessName(String businessName);

  boolean existsByRuc(int ruc);

  @Query("SELECT c FROM Company c ORDER BY c.id DESC")
  List<Company> findLastRecords(Pageable pageable);
}
