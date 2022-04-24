package com.bosonit.education.rs1.infrastructure.controller.dto.output;

import com.bosonit.education.rs1.domain.entity.Person;
import lombok.Getter;

@Getter
public class AddPersonOutputDto {

  private final String name;

  private final Integer age;

  public AddPersonOutputDto(Person person) {

    this.name = person.getName();
    this.age = person.getAge();

  }

}
