package com.github.airatgaliev.phonebook.payload;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ContactsRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactsRequest {

  @XmlElement
  private String type;

  @XmlElement
  private String position;

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
