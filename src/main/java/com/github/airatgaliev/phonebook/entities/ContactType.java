package com.github.airatgaliev.phonebook.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class ContactType implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false, unique = true)
  private Long id;
  @Column(nullable = false, updatable = false, unique = true)
  private String type;
  @XmlTransient
  @OneToMany(mappedBy = "contactType", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Contacts> contacts = new ArrayList<>();

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

  public List<Contacts> getContacts() {
    return contacts;
  }

  public void setContacts(List<Contacts> contacts) {
    this.contacts = contacts;
  }

  @Override
  public String toString() {
    return "ContactType{" +
        "id=" + id +
        ", type='" + type + '\'' +
        '}';
  }
}
