package com.bosonit.education.bs3.application.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AppStartService {

  @PostConstruct
  public void helloAfterStartup() {

    System.out.println("The application has been started");
  }

}
