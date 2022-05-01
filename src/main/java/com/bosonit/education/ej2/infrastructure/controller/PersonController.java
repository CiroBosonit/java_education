package com.bosonit.education.ej2.infrastructure.controller;

import com.bosonit.education.ej2.application.service.PersonService;
import com.bosonit.education.ej2.domain.entity.Person;
import com.bosonit.education.ej2.infrastructure.controller.dto.input.CreatePersonInputDto;
import com.bosonit.education.ej2.infrastructure.controller.dto.input.UpdatePersonInputDto;
import com.bosonit.education.ej2.infrastructure.controller.dto.output.PersonOutputDto;
import com.bosonit.education.shared.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "ej4")
public class PersonController {

  private final PersonService service;

  @GetMapping
  public List<PersonOutputDto> findAll() {

    List<Person> people = service.findAll();

    return people.stream().map(PersonOutputDto::new).toList();
  }

  @GetMapping(value = "search")
  public PersonOutputDto findByName(@RequestParam String user) throws NotFoundException {

    Person p = service.findByUser(user);

    return new PersonOutputDto(p);
  }

  @PostMapping
  public PersonOutputDto create(@Valid @RequestBody CreatePersonInputDto inputDto) {

    Person p = service.create(inputDto);

    return new PersonOutputDto(p);
  }

  @DeleteMapping(value = "{personId}")
  public ResponseEntity<Boolean> delete(@PathVariable Integer personId) {

    service.delete(personId);

    return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
  }

  @PutMapping(value = "{personId}")
  public PersonOutputDto update(@PathVariable Integer personId, @RequestBody UpdatePersonInputDto inputDto) throws NotFoundException {

    Person p = service.update(personId, inputDto);

    return new PersonOutputDto(p);
  }

}
