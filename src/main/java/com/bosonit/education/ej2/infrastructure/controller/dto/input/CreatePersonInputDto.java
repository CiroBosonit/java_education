package com.bosonit.education.ej2.infrastructure.controller.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreatePersonInputDto {

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

  /**
   * Checks whether the input fulfills the required conditions.
   */
  public void validateFields() {

    if (null == user) {
      throw new IllegalStateException("The field user cannot be null");
    }

    if (user.length() > 10) {
      throw new IllegalStateException("The length of the field user cannot exceed 10 characters");
    }
  }

}
