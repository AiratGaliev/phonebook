package com.github.airatgaliev.phonebook.repositories;

import com.github.airatgaliev.phonebook.entities.ContactType;
import com.github.airatgaliev.phonebook.entities.Contacts;
import com.github.airatgaliev.phonebook.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface ContactsRepository extends CrudRepository<Contacts, Long> {

  Contacts findContactsById(Long id);

  Iterable<Contacts> findAll();

  Iterable<Contacts> findContactsByContactType(ContactType contactType);

  Iterable<Contacts> findContactsByPerson(Person person);

  void delete(Contacts contacts);
}
