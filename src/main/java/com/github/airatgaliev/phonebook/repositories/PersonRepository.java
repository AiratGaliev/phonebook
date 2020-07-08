package com.github.airatgaliev.phonebook.repositories;

import com.github.airatgaliev.phonebook.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

  Person findPersonById(Long id);

  Iterable<Person> findAll();

  void delete(Person person);
}
