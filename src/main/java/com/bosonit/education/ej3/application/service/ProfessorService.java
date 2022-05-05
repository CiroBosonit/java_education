package com.bosonit.education.ej3.application.service;

import com.bosonit.education.ej3.domain.entity.Professor;
import com.bosonit.education.ej3.infrastructure.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfessorService {

  private final ProfessorRepository repo;

  public Professor create(Professor p) {

    return repo.save(p);
  }

}
