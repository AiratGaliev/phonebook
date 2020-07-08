package com.github.airatgaliev.phonebook.payload;

import com.github.airatgaliev.phonebook.entities.Contacts;
import com.github.airatgaliev.phonebook.entities.Person;
import java.util.List;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ContactsResponse")
public class ContactsResponse {

  private List<Contacts> contacts;

  private Person person;

  public List<Contacts> getContacts() {
    return contacts;
  }

  public void setContacts(List<Contacts> contacts) {
    this.contacts = contacts;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}
