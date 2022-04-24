package com.bosonit.education.rs1.application.service;

import com.bosonit.education.rs1.application.exception.PersonNotFoundException;
import com.bosonit.education.rs1.domain.entity.Person;
import com.bosonit.education.rs1.infrastructure.controller.dto.input.AddPersonInputDto;
import com.bosonit.education.rs1.infrastructure.controller.dto.input.UpdatePersonInputDto;

public interface CrudService {

  Person addPerson(AddPersonInputDto inputDto);

  Person findById(int personId) throws PersonNotFoundException;

  Person updatePerson(Person person, UpdatePersonInputDto inputDto);

  boolean deletePerson(Person p);

}
