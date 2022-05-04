package com.bosonit.education.ej2.infrastructure.controller.dto.input;

import com.bosonit.education.ej2.infrastructure.PatchField;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UpdatePersonInputDto {

  @PatchField
  private String user;

  private String password;
  private String name;
  private String surname;
  private String companyEmail;
  private String personalEmail;
  private String city;
  private Boolean active;
  private LocalDate createdDate;
  private String imageUrl;
  private LocalDate terminationDate;

}
