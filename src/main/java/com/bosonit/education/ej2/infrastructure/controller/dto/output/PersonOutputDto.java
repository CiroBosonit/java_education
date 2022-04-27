package com.bosonit.education.ej2.infrastructure.controller.dto.output;

import com.bosonit.education.ej2.domain.entity.Person;
import lombok.Getter;

import java.time.LocalDate;

/**
 * This class represents the output for an entity of type Person
 */
@Getter
public class PersonOutputDto {

  private final Integer personId;
  private final String user;
  private final String password;
  private final String name;
  private final String surname;
  private final String companyEmail;
  private final String personalEmail;
  private final String city;
  private final Boolean active;
  private final LocalDate createdDate;
  private final String imageUrl;
  private final LocalDate terminationDate;

  /**
   * Maps an entity to its output representation.
   *
   * @param p Person The entity to be sent on the request
   */
  public PersonOutputDto(Person p) {

    this.personId = p.getPersonId();
    this.user = p.getUser();
    this.password = p.getPassword();
    this.name = p.getName();
    this.surname = p.getSurname();
    this.companyEmail = p.getCompanyEmail();
    this.personalEmail = p.getPersonalEmail();
    this.city = p.getCity();
    this.active = p.getActive();
    this.createdDate = p.getCreatedDate();
    this.imageUrl = p.getImageUrl();
    this.terminationDate = p.getTerminationDate();
  }

}
