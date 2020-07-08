package com.github.airatgaliev.phonebook.repositories;

import com.github.airatgaliev.phonebook.entities.ContactType;
import org.springframework.data.repository.CrudRepository;

public interface ContactTypeRepository extends CrudRepository<ContactType, Long> {

  ContactType findContactTypeById(Long id);

  Iterable<ContactType> findAll();

  void delete(ContactType contactType);
}
