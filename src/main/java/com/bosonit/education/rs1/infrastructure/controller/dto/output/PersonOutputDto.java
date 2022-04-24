package com.bosonit.education.rs1.infrastructure.controller.dto.output;

import com.bosonit.education.rs1.domain.entity.Person;
import lombok.Getter;

@Getter
public class PersonOutputDto {

  private Integer id;

  private String name;

  private Integer age;

  public PersonOutputDto(Person person) {

    this.id = person.getId();
    this.name = person.getName();
    this.age = person.getAge();

  }

}
