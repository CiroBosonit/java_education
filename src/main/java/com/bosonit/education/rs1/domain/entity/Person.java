package com.bosonit.education.rs1.domain.entity;

import com.bosonit.education.rs1.infrastructure.controller.dto.input.AddPersonInputDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Person {

  private Integer id;

  private String name;

  private Integer age;

  private String town;

  public Person(AddPersonInputDto inputDto, Integer id) {

    this.id = id;
    this.name = inputDto.getName();
    this.age = inputDto.getAge();
    this.town = inputDto.getTown();

  }

}
