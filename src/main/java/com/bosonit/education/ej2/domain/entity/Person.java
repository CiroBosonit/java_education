package com.bosonit.education.ej2.domain.entity;

import com.bosonit.education.ej2.infrastructure.controller.dto.input.CreatePersonInputDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "person_id", nullable = false)
  private Integer personId;

  @Column(name = "user", length = 10)
  private String user;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "company_email", nullable = false)
  private String companyEmail;

  @Column(name = "personal_email", nullable = false)
  private String personalEmail;

  @Column(name = "city", nullable = false)
  private String city;

  @Column(name = "active", nullable = false)
  private Boolean active = false;

  @Column(name = "created_date", nullable = false)
  private LocalDate createdDate;

  @Column(name = "image_url")
  private String imageUrl;

  @Column(name = "termination_date")
  private LocalDate terminationDate;

  /**
   * Creates an instance of the Person class from its InputDto representation.
   *
   * @param inputDto CreatePersonInputDto The necessary data to create a new registry
   */
  public Person(CreatePersonInputDto inputDto) {

    this.user = inputDto.getUser();
    this.password = inputDto.getPassword();
    this.name = inputDto.getName();
    this.surname = inputDto.getSurname();
    this.companyEmail = inputDto.getCompanyEmail();
    this.personalEmail = inputDto.getPersonalEmail();
    this.city = inputDto.getCity();
    this.active = inputDto.getActive();
    this.createdDate = inputDto.getCreatedDate();
    this.imageUrl = inputDto.getImageUrl();
    this.terminationDate = inputDto.getTerminationDate();
  }

}
