package com.bosonit.education.ej2.application.service;

import com.bosonit.education.ej2.domain.entity.Person;
import com.bosonit.education.ej2.infrastructure.controller.dto.input.CreatePersonInputDto;
import com.bosonit.education.ej2.infrastructure.controller.dto.input.UpdatePersonInputDto;
import com.bosonit.education.ej2.infrastructure.repository.jpa.PersonRepository;
import com.bosonit.education.shared.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

  private final PersonRepository repo;

  @Override
  public List<Person> findAll() {

    return repo.findAll();
  }

  @Override
  public Person create(CreatePersonInputDto inputDto) {

    Person newPerson = new Person(inputDto);

    return repo.save(newPerson);
  }

  @Override
  public void delete(Integer personId) {

    repo.deleteById(personId);
  }

  @Override
  public Person update(Integer personId, UpdatePersonInputDto inputDto) throws NotFoundException {

    Person p = repo.findById(personId).orElseThrow(() -> new NotFoundException("Person", personId));

    // Update all the available information
    p.setUser(inputDto.getUser());
    p.setPassword(p.getPassword());
    p.setName(inputDto.getName());
    p.setSurname(inputDto.getSurname());
    p.setCompanyEmail(inputDto.getCompanyEmail());
    p.setPersonalEmail(inputDto.getPersonalEmail());
    p.setCity(inputDto.getCity());
    p.setActive(inputDto.getActive());
    p.setCreatedDate(inputDto.getCreatedDate());
    p.setImageUrl(inputDto.getImageUrl());
    p.setTerminationDate(inputDto.getTerminationDate());

    return repo.save(p);

  }

  @Override
  public Person findByUser(String user) throws NotFoundException {

    return repo.findByUser(user).orElseThrow(() -> new NotFoundException("Person", "user", user));
  }

  @Override
  public Person patch(Integer personId, Map<Object, Object> inputDto) throws NotFoundException {

    Person p = repo.findById(personId).orElseThrow(() -> new NotFoundException("Person", personId));

    inputDto.forEach((k, v) -> {
      Field field = ReflectionUtils.findField(Person.class, (String) k);
      field.setAccessible(true);
      ReflectionUtils.setField(field, p, v);
    });

    return repo.save(p);
  }

}
