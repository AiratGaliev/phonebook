package com.github.airatgaliev.phonebook.payload;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ContactsRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactsRequest {

  @XmlElement
  private Long id;
  @XmlElement
  private Long contactTypeId;
  @XmlElement
  private Long personId;
  @XmlElement
  private String number;
  @XmlElement
  private String type;
  @XmlElement
  private String position;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getContactTypeId() {
    return contactTypeId;
  }

  public void setContactTypeId(Long contactTypeId) {
    this.contactTypeId = contactTypeId;
  }

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }
}
