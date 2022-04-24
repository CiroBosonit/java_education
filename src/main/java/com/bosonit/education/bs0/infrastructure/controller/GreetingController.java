package com.bosonit.education.bs0.infrastructure.controller;

import com.bosonit.education.bs0.domain.entity.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "bs0")
public class GreetingController {

  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam String name) {

    return new Greeting(name);
  }

}
