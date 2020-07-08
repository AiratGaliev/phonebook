package com.github.airatgaliev.phonebook.services;

import com.github.airatgaliev.phonebook.entities.ContactType;
import com.github.airatgaliev.phonebook.entities.Contacts;
import com.github.airatgaliev.phonebook.entities.Person;
import com.github.airatgaliev.phonebook.payload.ContactsRequest;
import com.github.airatgaliev.phonebook.payload.ContactsResponse;
import com.github.airatgaliev.phonebook.repositories.ContactTypeRepository;
import com.github.airatgaliev.phonebook.repositories.ContactsRepository;
import com.github.airatgaliev.phonebook.repositories.PersonRepository;
import java.util.List;
import javax.jws.WebMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactsServiceImpl implements IContactsService {

  private final ContactsRepository contactsRepository;
  private final ContactTypeRepository contactTypeRepository;
  private final PersonRepository personRepository;

  @Autowired
  public ContactsServiceImpl(ContactsRepository contactsRepository,
      ContactTypeRepository contactTypeRepository,
      PersonRepository personRepository) {
    this.contactsRepository = contactsRepository;
    this.contactTypeRepository = contactTypeRepository;
    this.personRepository = personRepository;
  }

  @Override
  public ContactsResponse getContacts(ContactsRequest contactsRequest) {
    List<Contacts> contacts = contactsRepository.findAll();
    ContactsResponse contactsResponse = new ContactsResponse();
    contactsResponse.setContactsList(contacts);
    return contactsResponse;
  }

  @Override
  public ContactsResponse getContactsById(ContactsRequest contactsRequest) {
    Contacts contacts = contactsRepository.findContactsById(contactsRequest.getId());
    ContactsResponse contactsResponse = new ContactsResponse();
    contactsResponse.setContacts(contacts);
    return contactsResponse;
  }

  @WebMethod
  public ContactsResponse getContactsByTypeOrPosition(ContactsRequest contactsRequest) {
    String contactType = contactsRequest.getType();
    String position = contactsRequest.getPosition();
    List<Contacts> contacts = contactsRepository
        .findContactsByContactType_TypeOrPerson_Position(contactType, position);
    ContactsResponse contactsResponse = new ContactsResponse();
    contactsResponse.setContactsList(contacts);
    return contactsResponse;
  }

  @Override
  public ContactsResponse getContactsByTypeAndPosition(ContactsRequest contactsRequest) {
    String contactType = contactsRequest.getType();
    String position = contactsRequest.getPosition();
    List<Contacts> contacts = contactsRepository
        .findContactsByContactType_TypeAndPerson_Position(contactType, position);
    ContactsResponse contactsResponse = new ContactsResponse();
    contactsResponse.setContactsList(contacts);
    return contactsResponse;
  }

  @Override
  public ContactsResponse createContacts(ContactsRequest contactsRequest) {
    Long contactTypeId = contactsRequest.getContactTypeId();
    Long personId = contactsRequest.getPersonId();
    String number = contactsRequest.getNumber();
    ContactType contactType = contactTypeRepository.findContactTypeById(contactTypeId);
    Person person = personRepository.findPersonById(personId);
    Contacts contacts = new Contacts(person, contactType, number);
    contactsRepository.save(contacts);
    ContactsResponse contactsResponse = new ContactsResponse();
    contactsResponse.setContacts(contacts);
    return contactsResponse;
  }

  @Override
  public ContactsResponse updateContacts(ContactsRequest contactsRequest) {
    Long id = contactsRequest.getId();
    String number = contactsRequest.getNumber();
    Contacts contacts = contactsRepository.findContactsById(id);
    contacts.setNumber(number);
    contactsRepository.save(contacts);
    ContactsResponse contactsResponse = new ContactsResponse();
    contactsResponse.setContacts(contacts);
    return contactsResponse;
  }

  @Override
  public String deleteContacts(ContactsRequest contactsRequest) {
    Long id = contactsRequest.getId();
    contactsRepository.deleteById(id);
    return String.format("Contacts with id=%d is deleted", id);
  }
}
