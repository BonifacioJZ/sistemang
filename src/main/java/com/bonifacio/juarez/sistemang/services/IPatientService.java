package com.bonifacio.juarez.sistemang.services;

import com.bonifacio.juarez.sistemang.dtos.AddFamiliar;
import com.bonifacio.juarez.sistemang.dtos.PatientDetails;
import com.bonifacio.juarez.sistemang.dtos.PatientInDto;
import com.bonifacio.juarez.sistemang.dtos.PatientOutDto;
import com.bonifacio.juarez.sistemang.entities.Patient;

public interface IPatientService {
  Iterable<PatientOutDto> getAllPatients();

  Patient savePatient(PatientInDto patientInDto);

  PatientDetails getPatientByCurp(String curp);

  PatientDetails addFamiliarToPatient(AddFamiliar addFamiliar);

}
