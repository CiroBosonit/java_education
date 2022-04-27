package com.bosonit.education.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * When an entity of is not found in the database
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

  public NotFoundException(String entity, Integer id) {

    super("No entity of type [" + entity + "] with id [" + id.toString() + "] found in the database");
  }

  public NotFoundException(String entity, String field, String value) {

    super("No entity of type [" + entity + "] with the field [" + field + ": " + value + " ] found in the database");
  }

}
