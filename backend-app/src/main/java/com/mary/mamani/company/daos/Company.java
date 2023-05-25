package com.mary.mamani.company.daos;

import com.mary.mamani.company.utils.constants.TableConstants.CompanyTable;
import com.mary.mamani.company.utils.constants.ValidationMessages.CompanyMessages;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = CompanyTable.TABLE_NAME)
public class Company {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = CompanyTable.ID)
  private Long id;

  @NotNull(message = CompanyMessages.RUC_NOT_NULL)
  @Digits(integer = 11, fraction = 0, message = CompanyMessages.RUC_DIGITS)
  @Column(name = CompanyTable.RUC)
  private int ruc;

  @NotBlank(message = CompanyMessages.BUSINESS_NAME_NOT_BLANK)
  @Size(max = 60, message = CompanyMessages.BUSINESS_NAME_SIZE)
  @Column(name = CompanyTable.BUSINESS_NAME)
  private String businessName;

  @Column(name = CompanyTable.ADDRESS)
  private String address;

  @Column(name = CompanyTable.STATUS)
  private Boolean status;

}
