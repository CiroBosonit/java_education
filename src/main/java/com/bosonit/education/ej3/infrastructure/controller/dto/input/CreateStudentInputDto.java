package com.bosonit.education.ej3.infrastructure.controller.dto.input;

import com.bosonit.education.ej3.domain.enums.BranchEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentInputDto {

  private int numHoursWeek;

  private BranchEnum branch;

  private String comments;

}
