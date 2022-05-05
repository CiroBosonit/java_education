package com.bosonit.education.ej3.infrastructure.controller.dto.input;

import com.bosonit.education.ej3.domain.enums.BranchEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CreateProfessorInputDto {

  private BranchEnum branch;

  private String comments;

  private List<Integer> studentsIds = new ArrayList<>();

}
