package com.bonifacio.juarez.sistemang.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * FamiliarOutDto
 */
public class FamiliarOutDto {

  private final UUID id;
  private final String name;
  private final String lastName;
  private final String phone;
  private final String email;
  private final String colony;
  private final String city;
  private final String address;
  private final String curp;
  private final Date birthday;
  private final String relationshp;
  private final ArrayList<PatientOutDto> patients;

  public FamiliarOutDto(UUID id, String name, String lastName, String phone, String email, String colony, String city,
      String address, String curp, Date birthday, String relationshp, ArrayList<PatientOutDto> patients) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.phone = phone;
    this.email = email;
    this.colony = colony;
    this.city = city;
    this.address = address;
    this.curp = curp;
    this.birthday = birthday;
    this.relationshp = relationshp;
    this.patients = patients;
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

  public String getAddress() {
    return address;
  }

  public String getCurp() {
    return curp;
  }

  public Date getBirthday() {
    return birthday;
  }

  public String getRelationshp() {
    return relationshp;
  }

  public ArrayList<PatientOutDto> getPatients() {
    return patients;
  }
}
