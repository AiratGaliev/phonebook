package com.github.airatgaliev.phonebook.services;

import com.github.airatgaliev.phonebook.payload.PersonRequest;
import com.github.airatgaliev.phonebook.payload.PersonResponse;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService(name = "IPersonService")
public interface IPersonService {

  @WebMethod
  PersonResponse getPersons(@XmlElement(required = true) PersonRequest personRequest);

  @WebMethod
  PersonResponse getPersonById(@XmlElement(required = true) PersonRequest personRequest);

  @WebMethod
  PersonResponse getPersonsByFirstNameOrLastNameOrMiddleName(
      @XmlElement(required = true) PersonRequest personRequest);

  @WebMethod
  PersonResponse getPersonsByFirstNameAndLastNameAndMiddleName(
      @XmlElement(required = true) PersonRequest personRequest);

  @WebMethod
  PersonResponse createPerson(@XmlElement(required = true) PersonRequest personRequest);

  @WebMethod
  PersonResponse updatePerson(@XmlElement(required = true) PersonRequest personRequest);

  @WebMethod
  String deletePerson(@XmlElement(required = true) PersonRequest personRequest);
}
