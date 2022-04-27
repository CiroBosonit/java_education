package com.bosonit.education.ej2.infrastructure.repository.jpa;

import com.bosonit.education.ej2.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

  Optional<Person> findByUser(String user);

}
