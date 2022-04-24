package com.bosonit.education.rs1.application.service;

import com.bosonit.education.rs1.application.exception.PersonNotFoundException;
import com.bosonit.education.rs1.domain.entity.Person;
import com.bosonit.education.rs1.infrastructure.controller.dto.input.AddPersonInputDto;
import com.bosonit.education.rs1.infrastructure.controller.dto.input.UpdatePersonInputDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CrudServiceImpl implements CrudService {

  private Set<Person> people = new HashSet<>();

  private Integer counter;

  public CrudServiceImpl() {

    counter = 1;
  }

  public Person addPerson(AddPersonInputDto inputDto) {

    Person p = new Person(inputDto, counter);
    this.people.add(p);
    counter++;

    return p;
  }

  public Person findById(int personId) throws PersonNotFoundException {

    return people.stream().filter(p -> p.getId().equals(personId)).findFirst().orElseThrow(() -> new PersonNotFoundException("Nonexisting person with id " + personId));

  }

  public Person updatePerson(Person person, UpdatePersonInputDto inputDto) {

    if (inputDto.getName() != null) {
      person.setName(inputDto.getName());
    }

    if (inputDto.getAge() != null) {
      person.setAge(inputDto.getAge());
    }

    return person;
  }

  public boolean deletePerson(Person p) {

    if (!this.people.contains(p)) {
      return false;
    }

    this.people.remove(p);
    return true;
  }

}
