package com.bosonit.education.rs1.infrastructure.controller;

import com.bosonit.education.rs1.application.exception.PersonNotFoundException;
import com.bosonit.education.rs1.domain.entity.Person;
import com.bosonit.education.rs1.domain.service.CrudService;
import com.bosonit.education.rs1.infrastructure.controller.dto.input.AddPersonInputDto;
import com.bosonit.education.rs1.infrastructure.controller.dto.input.UpdatePersonInputDto;
import com.bosonit.education.rs1.infrastructure.controller.dto.output.AddPersonOutputDto;
import com.bosonit.education.rs1.infrastructure.controller.dto.output.PersonOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "rs1")
public class CrudController {

  @Autowired
  CrudService service;

  @PostMapping
  public ResponseEntity<AddPersonOutputDto> addPerson(@RequestBody AddPersonInputDto inputDto) {

    Person p = service.addPerson(inputDto);

    return new ResponseEntity<>(new AddPersonOutputDto(p), HttpStatus.CREATED);

  }

  @GetMapping("{personId}")
  public PersonOutputDto getPerson(@PathVariable int personId) throws PersonNotFoundException {

    Person p = service.findById(personId);

    return new PersonOutputDto(p);
  }

  @PutMapping("{personId}")
  public ResponseEntity<PersonOutputDto> updatePerson(@PathVariable int personId, @RequestBody UpdatePersonInputDto inputDto) throws PersonNotFoundException {

    Person p = service.findById(personId);

    Person updatedPerson = service.updatePerson(p, inputDto);

    return new ResponseEntity<>(new PersonOutputDto(updatedPerson), HttpStatus.OK);
  }

  @DeleteMapping("{personId}")
  public ResponseEntity<Boolean> deletePerson(@PathVariable int personId) throws PersonNotFoundException {

    Person p = service.findById(personId);

    return new ResponseEntity<>(service.deletePerson(p), HttpStatus.NO_CONTENT);
  }

}
