package com.github.airatgaliev.phonebook.services;

import com.github.airatgaliev.phonebook.payload.ContactsRequest;
import com.github.airatgaliev.phonebook.payload.ContactsResponse;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService(name = "IContactsService")
public interface IContactsService {

  @WebMethod
  ContactsResponse getContacts(
      @XmlElement(required = true) ContactsRequest contactsRequest);

  @WebMethod
  ContactsResponse getContactsById(
      @XmlElement(required = true) ContactsRequest contactsRequest);

  @WebMethod
  ContactsResponse getContactsByTypeOrPosition(
      @XmlElement(required = true) ContactsRequest contactsRequest);

  @WebMethod
  ContactsResponse getContactsByTypeAndPosition(
      @XmlElement(required = true) ContactsRequest contactsRequest);

  @WebMethod
  ContactsResponse createContacts(
      @XmlElement(required = true) ContactsRequest contactsRequest);

  @WebMethod
  ContactsResponse updateContacts(
      @XmlElement(required = true) ContactsRequest contactsRequest);

  @WebMethod
  String deleteContacts(
      @XmlElement(required = true) ContactsRequest contactsRequest);
}
