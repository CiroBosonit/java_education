package com.bosonit.education.ej3.infrastructure.controller.dto.output;

import com.bosonit.education.ej3.domain.entity.Student;
import com.bosonit.education.ej3.domain.enums.BranchEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfessorOutputDto {

  private Integer id;

  private BranchEnum branch;

  private String comments;

  private List<Student> students;

}
