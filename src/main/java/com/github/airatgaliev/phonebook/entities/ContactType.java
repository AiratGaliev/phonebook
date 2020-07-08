package com.github.airatgaliev.phonebook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_type")
public class ContactType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false, unique = true)
  private Long id;
  @Column(nullable = false, updatable = false, unique = true)
  private String type;

  public ContactType() {
  }

  public ContactType(String type) {
    this.type = type;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "ContactType{" +
        "id=" + id +
        ", type='" + type + '\'' +
        '}';
  }
}
