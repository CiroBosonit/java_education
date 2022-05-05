package com.bosonit.education.ej2.infrastructure.controller;

import com.bosonit.education.ej2.application.service.PersonService;
import com.bosonit.education.ej2.domain.entity.Person;
import com.bosonit.education.ej2.infrastructure.controller.dto.input.CreatePersonInputDto;
import com.bosonit.education.ej2.infrastructure.controller.dto.input.UpdatePersonInputDto;
import com.bosonit.education.ej2.infrastructure.controller.dto.output.PersonOutputDto;
import com.bosonit.education.ej2.infrastructure.mapper.PersonMapper;
import com.bosonit.education.shared.exception.NotFoundException;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Api(tags = "EJ2")
@RestController
@AllArgsConstructor
@RequestMapping(value = "ej4")
public class PersonController {

  private final PersonService service;

  @GetMapping
  public List<PersonOutputDto> findAll() {

    List<Person> people = service.findAll();

    return people.stream().map(PersonMapper.INSTANCE::toDto).toList();
  }

  @GetMapping(value = "search")
  public PersonOutputDto findByName(@RequestParam String user) throws NotFoundException {

    Person p = service.findByUser(user);

    return PersonMapper.INSTANCE.toDto(p);
  }

  @PostMapping
  public PersonOutputDto create(@Valid @RequestBody CreatePersonInputDto inputDto) {

    Person p = service.create(inputDto);

    return PersonMapper.INSTANCE.toDto(p);
  }

  @DeleteMapping(value = "{personId}")
  public ResponseEntity<Boolean> delete(@PathVariable Integer personId) {

    service.delete(personId);

    return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
  }

  @PutMapping(value = "{personId}")
  public PersonOutputDto update(@PathVariable Integer personId, @RequestBody UpdatePersonInputDto inputDto) throws NotFoundException {

    Person p = service.update(personId, inputDto);

    return PersonMapper.INSTANCE.toDto(p);
  }

  @PatchMapping(value = "{personId}")
  public PersonOutputDto patch(@PathVariable Integer personId, @RequestBody Map<Object, Object> inputDto) throws NotFoundException {

    // UpdatePersonInputDto validatedInputDto = PatchInputChecker.check(UpdatePersonInputDto.class, inputDto);

    Person p = service.patch(personId, inputDto);

    return PersonMapper.INSTANCE.toDto(p);
  }

}
