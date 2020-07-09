package com.github.airatgaliev.phonebook.payload;

import com.github.airatgaliev.phonebook.entities.Contacts;
import java.util.List;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ContactsResponse")
public class ContactsResponse {

  private Contacts contacts;
  private List<Contacts> contactsList;

  public List<Contacts> getContactsList() {
    return contactsList;
  }

  public void setContactsList(
      List<Contacts> contactsList) {
    this.contactsList = contactsList;
  }

  public Contacts getContacts() {
    return contacts;
  }

  public void setContacts(Contacts contacts) {
    this.contacts = contacts;
  }
}
