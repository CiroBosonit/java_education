package com.bosonit.education.bs2.infrastructure.controller;

import com.bosonit.education.bs2.domain.entity.City;
import com.bosonit.education.bs2.domain.entity.Person;
import com.bosonit.education.bs2.domain.service.CitiesService;
import com.bosonit.education.bs2.domain.service.PeopleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "bs2")
public class ControllerTwo {

  @Autowired
  PeopleService peopleService;

  @Autowired
  CitiesService citiesService;

  /**
   * Exercise 1
   */
  @GetMapping(value = "person")
  public Person getPerson() {

    Person person = peopleService.getPerson();
    person.setAge(person.getAge() * 2);

    return person;
  }

  /**
   * Exercise 2
   */
  @GetMapping(value = "cities")
  public List<City> getCities() {

    return citiesService.getCities();
  }

}
