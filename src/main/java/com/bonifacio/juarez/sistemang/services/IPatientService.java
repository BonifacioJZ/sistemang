package com.bonifacio.juarez.sistemang.services;

import com.bonifacio.juarez.sistemang.dtos.PatientInDto;
import com.bonifacio.juarez.sistemang.dtos.PatientOutDto;
import com.bonifacio.juarez.sistemang.entities.Patient;

public interface IPatientService {
  Iterable<PatientOutDto> getAllPatients();

  Patient savePatient(PatientInDto patientInDto);
}
