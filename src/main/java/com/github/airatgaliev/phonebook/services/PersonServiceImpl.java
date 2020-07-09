package com.github.airatgaliev.phonebook.services;

import com.github.airatgaliev.phonebook.entities.Person;
import com.github.airatgaliev.phonebook.payload.PersonRequest;
import com.github.airatgaliev.phonebook.payload.PersonResponse;
import com.github.airatgaliev.phonebook.repositories.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {

  private final PersonRepository personRepository;

  @Autowired
  public PersonServiceImpl(
      PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public PersonResponse getPersons(PersonRequest personRequest) {
    List<Person> personList = personRepository.findAll();
    PersonResponse personResponse = new PersonResponse();
    personResponse.setPersonList(personList);
    return personResponse;
  }

  @Override
  public PersonResponse getPersonById(PersonRequest personRequest) {
    Long id = personRequest.getId();
    Person person = personRepository.findPersonById(id);
    PersonResponse personResponse = new PersonResponse();
    personResponse.setPerson(person);
    return personResponse;
  }

  @Override
  public PersonResponse getPersonsByFirstNameOrLastNameOrMiddleName(PersonRequest personRequest) {
    String firstName = personRequest.getFirstName();
    String lastName = personRequest.getLastName();
    String middleName = personRequest.getMiddleName();
    List<Person> personList = personRepository
        .findPersonByFirstNameOrLastNameOrMiddleName(firstName, lastName, middleName);
    PersonResponse personResponse = new PersonResponse();
    personResponse.setPersonList(personList);
    return personResponse;
  }

  @Override
  public PersonResponse getPersonsByFirstNameAndLastNameAndMiddleName(PersonRequest personRequest) {
    String firstName = personRequest.getFirstName();
    String lastName = personRequest.getLastName();
    String middleName = personRequest.getMiddleName();
    List<Person> personList = personRepository
        .findPersonByFirstNameAndLastNameAndMiddleName(firstName, lastName, middleName);
    PersonResponse personResponse = new PersonResponse();
    personResponse.setPersonList(personList);
    return personResponse;
  }

  @Override
  public PersonResponse createPerson(PersonRequest personRequest) {
    String firstName = personRequest.getFirstName();
    String lastName = personRequest.getLastName();
    String middleName = personRequest.getMiddleName();
    String position = personRequest.getPosition();
    Person person = new Person(firstName, lastName, middleName, position);
    personRepository.save(person);
    PersonResponse personResponse = new PersonResponse();
    personResponse.setPerson(person);
    return personResponse;
  }

  @Override
  public PersonResponse updatePerson(PersonRequest personRequest) {
    Long id = personRequest.getId();
    String firstName = personRequest.getFirstName();
    String lastName = personRequest.getLastName();
    String middleName = personRequest.getMiddleName();
    String position = personRequest.getPosition();
    Person person = personRepository.findPersonById(id);
    person.setFirstName(firstName);
    person.setLastName(lastName);
    person.setMiddleName(middleName);
    person.setPosition(position);
    personRepository.save(person);
    PersonResponse personResponse = new PersonResponse();
    personResponse.setPerson(person);
    return personResponse;
  }

  @Override
  public String deletePerson(PersonRequest personRequest) {
    Long id = personRequest.getId();
    personRepository.deleteById(id);
    return String.format("Person with id=%d is deleted", id);
  }
}
