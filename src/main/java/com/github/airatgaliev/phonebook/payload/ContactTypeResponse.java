package com.github.airatgaliev.phonebook.payload;

import com.github.airatgaliev.phonebook.entities.ContactType;
import java.util.List;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ContactTypeResponse")
public class ContactTypeResponse {

  private ContactType contactType;
  private List<ContactType> contactTypes;

  public ContactType getContactType() {
    return contactType;
  }

  public void setContactType(ContactType contactType) {
    this.contactType = contactType;
  }

  public List<ContactType> getContactTypes() {
    return contactTypes;
  }

  public void setContactTypes(
      List<ContactType> contactTypes) {
    this.contactTypes = contactTypes;
  }
}
