package com.github.airatgaliev.phonebook.services;

import com.github.airatgaliev.phonebook.entities.Contacts;
import com.github.airatgaliev.phonebook.payload.ContactsRequest;
import com.github.airatgaliev.phonebook.payload.ContactsResponse;
import com.github.airatgaliev.phonebook.repositories.ContactsRepository;
import java.util.List;
import javax.jws.WebMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactsServiceImpl implements IContactsService {

  private final ContactsRepository contactsRepository;

  @Autowired
  public ContactsServiceImpl(
      ContactsRepository contactsRepository) {
    this.contactsRepository = contactsRepository;
  }

  @WebMethod
  public ContactsResponse getContactsByTypeOrPosition(ContactsRequest contactsRequest) {
    String contactType = contactsRequest.getType();
    String position = contactsRequest.getPosition();
    List<Contacts> contacts = contactsRepository
        .findContactsByContactType_TypeOrPerson_Position(contactType, position);
    ContactsResponse contactsResponse = new ContactsResponse();
    contactsResponse.setContacts(contacts);
    return contactsResponse;
  }

  @Override
  public ContactsResponse getContactsByTypeAndPosition(ContactsRequest contactsRequest) {
    String contactType = contactsRequest.getType();
    String position = contactsRequest.getPosition();
    List<Contacts> contacts = contactsRepository
        .findContactsByContactType_TypeAndPerson_Position(contactType, position);
    ContactsResponse contactsResponse = new ContactsResponse();
    contactsResponse.setContacts(contacts);
    return contactsResponse;
  }
}
