package com.bosonit.education.ej3.infrastructure.controller;

import com.bosonit.education.ej3.application.service.ProfessorService;
import com.bosonit.education.ej3.domain.entity.Professor;
import com.bosonit.education.ej3.domain.entity.Student;
import com.bosonit.education.ej3.infrastructure.controller.dto.input.CreateProfessorInputDto;
import com.bosonit.education.ej3.infrastructure.controller.dto.output.ProfessorOutputDto;
import com.bosonit.education.ej3.infrastructure.mapper.ProfessorMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(name = "ej3")
@AllArgsConstructor
public class ProfessorController {

  private final ProfessorService service;

  @PostMapping(name = "/professors")
  public ProfessorOutputDto create(@RequestBody CreateProfessorInputDto inputDto) {

    List<Student> students = inputDto.getStudentsIds().isEmpty() ? new ArrayList<>() : inputDto.getStudentsIds().stream().map(Student::new).toList();

    Professor p = ProfessorMapper.INSTANCE.toEntity(inputDto, students);

    return ProfessorMapper.INSTANCE.toDto(service.create(p));
  }

}
