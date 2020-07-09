package com.github.airatgaliev.phonebook.repositories;

import com.github.airatgaliev.phonebook.entities.Contacts;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepository extends CrudRepository<Contacts, Long> {

  Contacts findContactsById(Long id);

  List<Contacts> findAll();

  List<Contacts> findContactsByContactType_TypeOrPerson_Position(String type, String position);

  List<Contacts> findContactsByContactType_TypeAndPerson_Position(String type, String position);

  void deleteById(Long id);
}
