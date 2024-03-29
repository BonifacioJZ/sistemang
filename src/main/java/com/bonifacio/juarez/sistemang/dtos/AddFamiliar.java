package com.bonifacio.juarez.sistemang.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * addFamiliar
 */
public class AddFamiliar {

  @NotEmpty
  @NotBlank
  @Size(max = 18, min = 18)
  private final String patientCurp;
  @NotBlank
  @NotEmpty
  @Size(max = 18, min = 18)
  private final String familiarCurp;

  public AddFamiliar(String patientCurp, String familiarCurp) {
    this.patientCurp = patientCurp;
    this.familiarCurp = familiarCurp;
  }

  public String getPatientCurp() {
    return patientCurp;
  }

  public String getFamiliarCurp() {
    return familiarCurp;
  }
}
