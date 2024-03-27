package com.bonifacio.juarez.sistemang.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Size(max = 100)
  @NotNull
  @Column
  private String name;
  @Size(max = 150)
  @NotNull
  @Column(name = "last_name")
  private String lastName;
  @NotNull
  @Size(max = 13, min = 10)
  private String phone;
  @Email
  @Column
  private String email;
  @Size(max = 200)
  @NotNull
  @Column
  private String colony;
  @Size(max = 200)
  @NotNull
  @Column
  private String city;
  @NotNull
  @Column
  private Date birthday;
  @NotNull
  @Column
  private String address;
  @Size(max = 18, min = 18)
  @NotNull
  @Column(unique = true)
  private String curp;

  public Person(String name, String lastName, String phone, String email, String colony, String city, Date birthday,
      String address, String curp) {
    this.name = name;
    this.lastName = lastName;
    this.phone = phone;
    this.email = email;
    this.colony = colony;
    this.city = city;
    this.birthday = birthday;
    this.address = address;
    this.curp = curp;
  }

  public Person() {

  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getColony() {
    return colony;
  }

  public void setColony(String colony) {
    this.colony = colony;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCurp() {
    return curp;
  }

  public void setCurp(String curp) {
    this.curp = curp;
  }
}
