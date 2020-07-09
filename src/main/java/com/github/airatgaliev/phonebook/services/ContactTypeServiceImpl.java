package com.github.airatgaliev.phonebook.services;

import com.github.airatgaliev.phonebook.entities.ContactType;
import com.github.airatgaliev.phonebook.payload.ContactTypeRequest;
import com.github.airatgaliev.phonebook.payload.ContactTypeResponse;
import com.github.airatgaliev.phonebook.repositories.ContactTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactTypeServiceImpl implements IContactTypeService {

  private final ContactTypeRepository contactTypeRepository;

  @Autowired
  public ContactTypeServiceImpl(
      ContactTypeRepository contactTypeRepository) {
    this.contactTypeRepository = contactTypeRepository;
  }

  @Override
  public ContactTypeResponse getContactTypes(ContactTypeRequest contactTypeRequest) {
    List<ContactType> contactTypes = contactTypeRepository.findAll();
    ContactTypeResponse contactTypeResponse = new ContactTypeResponse();
    contactTypeResponse.setContactTypes(contactTypes);
    return contactTypeResponse;
  }

  @Override
  public ContactTypeResponse getContactTypeById(ContactTypeRequest contactTypeRequest) {
    Long id = contactTypeRequest.getId();
    ContactType contactType = contactTypeRepository.findContactTypeById(id);
    ContactTypeResponse contactTypeResponse = new ContactTypeResponse();
    contactTypeResponse.setContactType(contactType);
    return contactTypeResponse;
  }

  @Override
  public ContactTypeResponse getContactTypeByType(ContactTypeRequest contactTypeRequest) {
    String type = contactTypeRequest.getType();
    ContactType contactType = contactTypeRepository.findContactTypeByType(type);
    ContactTypeResponse contactTypeResponse = new ContactTypeResponse();
    contactTypeResponse.setContactType(contactType);
    return contactTypeResponse;
  }

  @Override
  public ContactTypeResponse createContactType(ContactTypeRequest contactTypeRequest) {
    String type = contactTypeRequest.getType();
    ContactType contactType = new ContactType(type);
    contactTypeRepository.save(contactType);
    ContactTypeResponse contactTypeResponse = new ContactTypeResponse();
    contactTypeResponse.setContactType(contactType);
    return contactTypeResponse;
  }

  @Override
  public ContactTypeResponse updateContactType(ContactTypeRequest contactTypeRequest) {
    Long id = contactTypeRequest.getId();
    String type = contactTypeRequest.getType();
    ContactType contactType = contactTypeRepository.findContactTypeById(id);
    contactType.setType(type);
    contactTypeRepository.save(contactType);
    ContactTypeResponse contactTypeResponse = new ContactTypeResponse();
    contactTypeResponse.setContactType(contactType);
    return contactTypeResponse;
  }

  @Override
  public String deleteContactType(ContactTypeRequest contactTypeRequest) {
    Long id = contactTypeRequest.getId();
    contactTypeRepository.deleteById(id);
    return String.format("ContactType with id=%d is deleted", id);
  }
}
