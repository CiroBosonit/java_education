package com.bosonit.education.ej3.application.service;

import com.bosonit.education.ej3.domain.entity.Student;
import com.bosonit.education.ej3.infrastructure.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

  private final StudentRepository repo;

  public Student create(Student p) {

    return repo.save(p);
  }

}
