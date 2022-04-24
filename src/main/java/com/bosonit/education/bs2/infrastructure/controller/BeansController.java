package com.bosonit.education.bs2.infrastructure.controller;

import com.bosonit.education.bs2.domain.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "bs2")
public class BeansController {

  @Autowired
  @Qualifier("personOne")
  Person p1;

  @Autowired
  @Qualifier("personTwo")
  Person p2;

  @Autowired
  @Qualifier("personThree")
  Person p3;

  /**
   * Exercise 3
   */
  @GetMapping(value = "bean")
  public Person getBean(@RequestParam int beanId) {

    return switch (beanId) {
      case 1 -> p1;
      case 2 -> p2;
      case 3 -> p3;
      default -> throw new IllegalStateException("Nonexisting bean" + beanId);
    };
  }

}
