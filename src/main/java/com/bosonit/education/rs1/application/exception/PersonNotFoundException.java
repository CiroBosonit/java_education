package com.bosonit.education.rs1.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {

  public PersonNotFoundException(String message) {

    super(message);
  }

}
