package com.bonifacio.juarez.sistemang.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "relatives")
public class Familiar extends Person {
  @Size(max = 100)
  @NotNull
  @Column
  private String relationship;
  @ManyToMany(mappedBy = "familiars")
  private Set<Patient> patients = new HashSet<>();

  public Familiar(String name, String lastName, String phone, String email, String colony, String city, Date birthday,
      String address, String curp, String relationship) {
    super(name, lastName, phone, email, colony, city, birthday, address, curp);
    this.relationship = relationship;
  }

  public Familiar() {
    super();
  }

  public String getRelationship() {
    return relationship;
  }

  public void setRelationship(String relationship) {
    this.relationship = relationship;
  }

  public Set<Patient> getPatients() {
    return patients;
  }

  public void setPatients(Set<Patient> patients) {
    this.patients = patients;
  }

  public void addPatient(Patient patient) {

    patients.add(patient);
    patient.getFamiliars().add(this);
  }
}
