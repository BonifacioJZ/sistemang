package com.bonifacio.juarez.sistemang.dtos;

import jakarta.validation.constraints.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class FamiliarIntDto {
  @Size(max = 100)
  @NotBlank
  @NotEmpty
  private final String name;
  @Size(max = 150)
  @NotBlank
  @NotEmpty
  private final String lastName;

  @Size(max = 13, min = 10)
  private final String phone;
  @Email
  private final String email;
  @Size(max = 200)
  @NotBlank
  @NotEmpty
  private final String colony;
  @Size(max = 200)
  @NotEmpty
  @NotBlank
  private final String city;
  @NotNull
  private final Date birthday;
  @NotBlank
  @NotEmpty
  private final String address;
  @Size(max = 18, min = 18)
  @NotBlank
  @NotEmpty
  private final String curp;
  @Size(max = 100)
  @NotBlank
  @NotEmpty
  private final String relationship;
  @NotEmpty
  @NotBlank
  @Size(min = 18, max = 18)
  private final String patient_curp;

  public FamiliarIntDto(String name, String lastName, String phone, String email, String colony, String city,
      Date birthday, String address, String curp, String relationship, String patient_curp) {
    this.name = name;
    this.lastName = lastName;
    if (StringUtils.isAllEmpty(phone)) {
      this.phone = "000-00-00-000";
    } else {
      this.phone = phone;
    }
    this.email = email;
    this.colony = colony;
    this.city = city;
    this.birthday = birthday;
    this.address = address;
    this.curp = curp;
    this.relationship = relationship;
    this.patient_curp = patient_curp;
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

  public String getRelationship() {
    return relationship;
  }
}
