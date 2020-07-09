package com.github.airatgaliev.phonebook.repositories;

import com.github.airatgaliev.phonebook.entities.Person;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

  Person findPersonById(Long id);

  List<Person> findAll();

  List<Person> findPersonByFirstNameOrLastNameOrMiddleName(String firstName, String lastName,
      String middleName);

  List<Person> findPersonByFirstNameAndLastNameAndMiddleName(String firstName, String lastName,
      String middleName);

  void deleteById(Long id);
}
