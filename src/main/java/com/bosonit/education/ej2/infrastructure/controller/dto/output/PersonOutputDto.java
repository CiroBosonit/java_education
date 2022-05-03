package com.bosonit.education.ej2.infrastructure.controller.dto.output;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * This class represents the output for an entity of type Person
 */
@Getter
@Setter
public class PersonOutputDto {

  private Integer personId;
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
