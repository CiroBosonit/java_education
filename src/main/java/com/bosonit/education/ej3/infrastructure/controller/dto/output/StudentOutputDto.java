package com.bosonit.education.ej3.infrastructure.controller.dto.output;

import com.bosonit.education.ej3.domain.enums.BranchEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentOutputDto {

  private Integer id;

  private BranchEnum branch;

  private String comments;

}
