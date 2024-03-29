package com.bonifacio.juarez.sistemang.dtos;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

/**
 * PatientDetails
 */
public class PatientDetails {
  private final UUID id;
  private final String name;
  private final String lastName;
  private final String phone;
  private final String email;
  private final String colony;
  private final String address;
  private final String curp;
  private final Date birthday;
  private final Set<FamiliarOutDto> familiars;

  public PatientDetails(UUID id, String name, String lastName, String phone, String email, String colony, String address, String curp, Date birthday, Set<FamiliarOutDto> familiars) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.phone = phone;
    this.email = email;
    this.colony = colony;
    this.address = address;
    this.curp = curp;
    this.birthday = birthday;
    this.familiars = familiars;
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

  public String getAddress() {
    return address;
  }

  public String getCurp() {
    return curp;
  }

  public Date getBirthday() {
    return birthday;
  }

  public Set<FamiliarOutDto> getFamiliars() {
    return familiars;
  }
}
