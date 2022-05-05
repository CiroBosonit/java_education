package com.bosonit.education.ej3.infrastructure.mapper;

import com.bosonit.education.ej3.domain.entity.Professor;
import com.bosonit.education.ej3.domain.entity.Student;
import com.bosonit.education.ej3.infrastructure.controller.dto.input.CreateProfessorInputDto;
import com.bosonit.education.ej3.infrastructure.controller.dto.output.ProfessorOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProfessorMapper {

  ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

  ProfessorOutputDto toDto(Professor professor);

  @Mapping(target = "students", source = "students")
  Professor toEntity(CreateProfessorInputDto inputDto, List<Student> students);

}
