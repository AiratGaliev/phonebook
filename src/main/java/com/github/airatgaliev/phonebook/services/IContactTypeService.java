package com.github.airatgaliev.phonebook.services;

import com.github.airatgaliev.phonebook.payload.ContactTypeRequest;
import com.github.airatgaliev.phonebook.payload.ContactTypeResponse;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService(name = "IContactTypeService")
public interface IContactTypeService {

  @WebMethod
  ContactTypeResponse getContactTypes(
      @XmlElement(required = true) ContactTypeRequest contactTypeRequest);

  @WebMethod
  ContactTypeResponse getContactTypeById(
      @XmlElement(required = true) ContactTypeRequest contactTypeRequest);

  @WebMethod
  ContactTypeResponse getContactTypeByType(
      @XmlElement(required = true) ContactTypeRequest contactTypeRequest);

  @WebMethod
  ContactTypeResponse createContactType(
      @XmlElement(required = true) ContactTypeRequest contactTypeRequest);

  @WebMethod
  ContactTypeResponse updateContactType(
      @XmlElement(required = true) ContactTypeRequest contactTypeRequest);

  @WebMethod
  String deleteContactType(
      @XmlElement(required = true) ContactTypeRequest contactTypeRequest);
}
