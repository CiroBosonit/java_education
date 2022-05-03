package com.bosonit.education.ej2.infrastructure.mapper;

import com.bosonit.education.ej2.domain.entity.Person;
import com.bosonit.education.ej2.infrastructure.controller.dto.output.PersonOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

  PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  PersonOutputDto toDto(Person person);

}
