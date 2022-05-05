package com.bosonit.education.ej3.infrastructure.mapper;

import com.bosonit.education.ej3.domain.entity.Student;
import com.bosonit.education.ej3.infrastructure.controller.dto.input.CreateStudentInputDto;
import com.bosonit.education.ej3.infrastructure.controller.dto.output.StudentOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

  StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

  StudentOutputDto toDto(Student professor);

  Student toEntity(CreateStudentInputDto inputDto);

}
