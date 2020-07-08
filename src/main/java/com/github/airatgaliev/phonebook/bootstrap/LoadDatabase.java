package com.github.airatgaliev.phonebook.bootstrap;

import com.github.airatgaliev.phonebook.entities.ContactType;
import com.github.airatgaliev.phonebook.entities.Contacts;
import com.github.airatgaliev.phonebook.entities.Person;
import com.github.airatgaliev.phonebook.repositories.ContactTypeRepository;
import com.github.airatgaliev.phonebook.repositories.ContactsRepository;
import com.github.airatgaliev.phonebook.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);

  private final ContactsRepository contactsRepository;

  private final ContactTypeRepository contactTypeRepository;

  private final PersonRepository personRepository;

  @Autowired
  public LoadDatabase(
      ContactsRepository contactsRepository,
      ContactTypeRepository contactTypeRepository,
      PersonRepository personRepository) {
    this.contactsRepository = contactsRepository;
    this.contactTypeRepository = contactTypeRepository;
    this.personRepository = personRepository;
  }

  @Bean
  CommandLineRunner initDatabase() {
    Person person1 = new Person("John", "Doe", "A", "developer");
    personRepository.save(person1);
    Person person2 = new Person("Ralf", "Hoe", "F", "tester");
    personRepository.save(person2);
    ContactType contactType1 = new ContactType("Partner");
    contactTypeRepository.save(contactType1);
    ContactType contactType2 = new ContactType("Vendor");
    contactTypeRepository.save(contactType2);
    return args -> {
      LOGGER.info("Preloading " + contactsRepository
          .save(new Contacts(person1, contactType1, "+1-202-555-0142")));
      LOGGER.info("Preloading " + contactsRepository
          .save(new Contacts(person2, contactType2, "+1-202-555-0122")));
    };
  }
}
