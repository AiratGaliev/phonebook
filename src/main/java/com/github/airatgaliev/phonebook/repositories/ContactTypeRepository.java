package com.github.airatgaliev.phonebook.repositories;

import com.github.airatgaliev.phonebook.entities.ContactType;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactTypeRepository extends CrudRepository<ContactType, Long> {

  ContactType findContactTypeById(Long id);

  ContactType findContactTypeByType(String typeName);

  List<ContactType> findAll();

  void delete(ContactType contactType);
}
