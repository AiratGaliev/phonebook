package com.github.airatgaliev.phonebook.repositories;

import com.github.airatgaliev.phonebook.entities.ContactType;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactTypeRepository extends CrudRepository<ContactType, Long> {

  ContactType findContactTypeById(Long id);

  List<ContactType> findAll();

  ContactType findContactTypeByType(String type);

  void deleteById(Long id);
}
