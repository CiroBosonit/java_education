package com.bosonit.education.bs4.infrastructure.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "BS4")
@RestController
@RequestMapping(value = "bs4")
public class ConfigController {

  @Value("${var1}")
  String myVar;

  @GetMapping
  public String getConfig() {

    return myVar;
  }

}
