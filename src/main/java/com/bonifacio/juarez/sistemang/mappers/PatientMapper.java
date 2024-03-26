package com.bonifacio.juarez.sistemang.mappers;

import org.springframework.stereotype.Component;

import com.bonifacio.juarez.sistemang.dtos.PatientInDto;
import com.bonifacio.juarez.sistemang.dtos.PatientOutDto;
import com.bonifacio.juarez.sistemang.entities.Patient;

@Component
public class PatientMapper implements IPatientMapper {

  @Override
  public Patient PatientInDtotoPatient(PatientInDto patientInDto) {
    if (patientInDto == null) {
      return null;
    }
    Patient patient = new Patient(patientInDto.getName(), patientInDto.getLastName(),
        patientInDto.getPhone(), patientInDto.getEmail(), patientInDto.getColony(), patientInDto.getCity(),
        patientInDto.getBirthday(), patientInDto.getAddress(), patientInDto.getCurp());
    return patient;
  }

  @Override
  public PatientOutDto PatientToPatientOutDto(Patient patient) {
    // TODO Auto-generated method stub
    if (patient == null) {
      return null;
    }
    PatientOutDto patientOutDto = new PatientOutDto(patient.getId(),
        patient.getName(), patient.getLastName(), patient.getPhone(),
        patient.getEmail(), patient.getColony(), patient.getCity(), patient.getBirthday(),
        patient.getAddress(), patient.getCurp());
    return patientOutDto;
  }

}
