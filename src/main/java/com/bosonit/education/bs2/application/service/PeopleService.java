package com.bosonit.education.bs2.application.service;

import com.bosonit.education.bs2.domain.entity.Person;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

  @Getter
  private Person person;

  public Person addPerson(String name, int age) {

    Person p = new Person(name, age);
    this.person = p;

    return p;
  }

  @Bean
  @Qualifier("personOne")
  public Person getPersonOne() {

    return new Person("Bean 1: Alberto", 25);
  }

  @Bean
  @Qualifier("personTwo")
  public Person getPersonTwo() {

    return new Person("Bean 2: Carla", 30);
  }

  @Bean
  @Qualifier("personThree")
  public Person getPersonThree() {

    return new Person("Bean 3: Eduardo", 35);
  }

}
