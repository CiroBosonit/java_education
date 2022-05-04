package com.bosonit.education.ej2.application.service;

import com.bosonit.education.ej2.domain.entity.Person;
import com.bosonit.education.ej2.infrastructure.PatchField;
import com.bosonit.education.ej2.infrastructure.controller.dto.input.CreatePersonInputDto;
import com.bosonit.education.ej2.infrastructure.controller.dto.input.UpdatePersonInputDto;
import com.bosonit.education.ej2.infrastructure.repository.jpa.PersonRepository;
import com.bosonit.education.shared.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

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
  public Person patch(Integer personId, UpdatePersonInputDto inputDto) throws NotFoundException, IllegalAccessException {

    // Retrieve entity from database
    Person p = repo.findById(personId).orElseThrow(() -> new NotFoundException("Person", personId));

    // Override entity with input values
    Field[] inputDtoFieldsWithData = inputDto.getClass().getDeclaredFields();

    for (Field f : inputDtoFieldsWithData) {

      f.setAccessible(true);
      boolean fieldIsOverridable = f.isAnnotationPresent(PatchField.class) && f.getAnnotation(PatchField.class).overrided();

      if (f.get(inputDto) != null || fieldIsOverridable) {
        ReflectionUtils.setField(f, p, f.get(inputDto));
      }
    }

    // Store in database
    return repo.save(p);
  }

}
