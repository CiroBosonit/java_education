package com.bosonit.education.ej2.infrastructure.controller.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class CreatePersonInputDto {

  @NotNull(message = "The field user cannot be null")
  @Max(value = 10, message = "The length of the field user cannot exceed 10 characters")
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
