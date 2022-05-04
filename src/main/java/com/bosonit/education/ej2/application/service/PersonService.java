package com.bosonit.education.ej2.application.service;

import com.bosonit.education.ej2.domain.entity.Person;
import com.bosonit.education.ej2.infrastructure.controller.dto.input.CreatePersonInputDto;
import com.bosonit.education.ej2.infrastructure.controller.dto.input.UpdatePersonInputDto;
import com.bosonit.education.shared.exception.NotFoundException;

import java.util.List;
import java.util.Map;

/**
 * Manages the basic functionalities of a person CRUD
 */
public interface PersonService {

  /**
   * Retrieves all the people existing on the database.
   *
   * @return List<Person> All the registries of type Person existing on the database
   */
  List<Person> findAll();

  /**
   * Creates a new entity of type person in the database.
   *
   * @param inputDto CreatePersonInputDto The necessary data to create a new person
   * @return People The new created registry
   */
  Person create(CreatePersonInputDto inputDto);

  /**
   * If existing, removes a person from the database.
   *
   * @param personId The identifier of the person to be removed
   */
  void delete(Integer personId);

  /**
   * Modifies all the data of a person.
   *
   * @param personId The identifier of the person to be modified
   * @param inputDto UpdatePersonInputDto The available data to be modified for a person
   * @return Person The updated registry
   * @throws NotFoundException When an entity of type person is not found in the database
   */
  Person update(Integer personId, UpdatePersonInputDto inputDto) throws NotFoundException;

  /**
   * Retrieves the Person with the given 'user' field.
   *
   * @param user String The name by which to search the person
   * @return Person The registry of type Person existing on the database
   * @throws NotFoundException When an entity of type person is not found in the database
   */
  Person findByUser(String user) throws NotFoundException;

  /**
   * Modifies some data of a person.
   *
   * @param personId The identifier of the person to be modified
   * @param inputDto UpdatePersonInputDto The available data to be modified for a person
   * @return Person The updated registry
   * @throws NotFoundException When an entity of type person is not found in the database
   */
  Person patch(Integer personId, UpdatePersonInputDto inputDto) throws NotFoundException, IllegalAccessException;

}
