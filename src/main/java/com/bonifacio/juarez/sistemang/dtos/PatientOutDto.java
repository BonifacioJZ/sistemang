package com.bonifacio.juarez.sistemang.dtos;

import java.util.Date;
import java.util.UUID;

public class PatientOutDto {
  private final UUID id;
  private final String name;
  private final String lastName;
  private final String phone;
  private final String email;
  private final String colony;
  private final String city;
  private final Date birthday;
  private final String address;
  private final String curp;

  public PatientOutDto(UUID id, String name, String lastName, String phone, String email, String colony, String city,
      Date birthday, String address, String curp) {
    this.id = id;
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

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public String getColony() {
    return colony;
  }

  public String getCity() {
    return city;
  }

  public Date getBirthday() {
    return birthday;
  }

  public String getAddress() {
    return address;
  }

  public String getCurp() {
    return curp;
  }
}
