package com.bosonit.education.bs2.infrastructure.controller;

import com.bosonit.education.bs2.domain.entity.City;
import com.bosonit.education.bs2.domain.entity.Person;
import com.bosonit.education.bs2.application.service.CitiesService;
import com.bosonit.education.bs2.application.service.PeopleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "bs2")
public class ControllerOne {

  @Autowired
  PeopleService peopleService;

  @Autowired
  CitiesService citiesService;

  /**
   * Exercise 1
   */
  @PostMapping(value = "person")
  public Person addPerson(@RequestParam String name, @RequestParam int age) {

    return peopleService.addPerson(name, age);
  }

  /**
   * Exercise 2
   */
  @PostMapping(value = "city")
  public City addCity(@RequestParam String name, @RequestParam int population) {

    return citiesService.addCity(name, population);
  }

}
