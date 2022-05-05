package com.bosonit.education.ej3.infrastructure.controller;

import com.bosonit.education.ej3.application.service.StudentService;
import com.bosonit.education.ej3.domain.entity.Student;
import com.bosonit.education.ej3.infrastructure.controller.dto.input.CreateStudentInputDto;
import com.bosonit.education.ej3.infrastructure.controller.dto.output.StudentOutputDto;
import com.bosonit.education.ej3.infrastructure.mapper.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "ej3")
@AllArgsConstructor
public class StudentController {

  private final StudentService service;

  @PostMapping(name = "/students")
  public StudentOutputDto create(@RequestBody CreateStudentInputDto inputDto) {

    Student p = StudentMapper.INSTANCE.toEntity(inputDto);

    return StudentMapper.INSTANCE.toDto(service.create(p));
  }

}
