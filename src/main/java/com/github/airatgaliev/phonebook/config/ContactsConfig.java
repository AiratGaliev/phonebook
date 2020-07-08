package com.github.airatgaliev.phonebook.config;

import com.github.airatgaliev.phonebook.repositories.ContactTypeRepository;
import com.github.airatgaliev.phonebook.repositories.ContactsRepository;
import com.github.airatgaliev.phonebook.repositories.PersonRepository;
import com.github.airatgaliev.phonebook.services.ContactsServiceImpl;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactsConfig {

  private final Bus bus;
  private final ContactsRepository contactsRepository;
  private final ContactTypeRepository contactTypeRepository;
  private final PersonRepository personRepository;

  @Autowired
  public ContactsConfig(Bus bus,
      ContactsRepository contactsRepository,
      ContactTypeRepository contactTypeRepository,
      PersonRepository personRepository) {
    this.bus = bus;
    this.contactsRepository = contactsRepository;
    this.contactTypeRepository = contactTypeRepository;
    this.personRepository = personRepository;
  }

  @Bean
  public Endpoint getContactsEndpoint() {
    Endpoint endpoint = new EndpointImpl(bus, new ContactsServiceImpl(contactsRepository,
        contactTypeRepository, personRepository));
    endpoint.publish("/Contacts");
    return endpoint;
  }
}
