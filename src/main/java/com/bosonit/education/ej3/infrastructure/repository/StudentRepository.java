package com.bosonit.education.ej3.infrastructure.repository;

import com.bosonit.education.ej3.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
