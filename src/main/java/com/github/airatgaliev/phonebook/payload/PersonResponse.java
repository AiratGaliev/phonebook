package com.github.airatgaliev.phonebook.payload;

import com.github.airatgaliev.phonebook.entities.Person;
import java.util.List;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "PersonResponse")
public class PersonResponse {

  private Person person;
  private List<Person> personList;

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public List<Person> getPersonList() {
    return personList;
  }

  public void setPersonList(List<Person> personList) {
    this.personList = personList;
  }
}
