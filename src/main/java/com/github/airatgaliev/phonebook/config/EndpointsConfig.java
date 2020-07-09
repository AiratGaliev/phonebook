package com.github.airatgaliev.phonebook.config;

import com.github.airatgaliev.phonebook.repositories.ContactTypeRepository;
import com.github.airatgaliev.phonebook.repositories.ContactsRepository;
import com.github.airatgaliev.phonebook.repositories.PersonRepository;
import com.github.airatgaliev.phonebook.services.ContactTypeServiceImpl;
import com.github.airatgaliev.phonebook.services.ContactsServiceImpl;
import com.github.airatgaliev.phonebook.services.PersonServiceImpl;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointsConfig {

  private final Bus bus;
  private final ContactsRepository contactsRepository;
  private final ContactTypeRepository contactTypeRepository;
  private final PersonRepository personRepository;

  @Autowired
  public EndpointsConfig(Bus bus,
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

  @Bean
  public Endpoint getContactTypeEndpoint() {
    Endpoint endpoint = new EndpointImpl(bus, new ContactTypeServiceImpl(contactTypeRepository));
    endpoint.publish("/ContactType");
    return endpoint;
  }

  @Bean
  public Endpoint getPersonEndpoint() {
    Endpoint endpoint = new EndpointImpl(bus, new PersonServiceImpl(personRepository));
    endpoint.publish("/Person");
    return endpoint;
  }
}
