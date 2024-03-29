package com.bonifacio.juarez.sistemang.mappers;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bonifacio.juarez.sistemang.dtos.FamiliarOutDto;
import com.bonifacio.juarez.sistemang.dtos.PatientDetails;
import com.bonifacio.juarez.sistemang.dtos.PatientInDto;
import com.bonifacio.juarez.sistemang.dtos.PatientOutDto;
import com.bonifacio.juarez.sistemang.entities.Patient;

@Mapper
public interface IPatientMapper {

  IPatientMapper INSTANCE = Mappers.getMapper(IPatientMapper.class);

  Patient PatientInDtotoPatient(PatientInDto patientInDto);

  PatientOutDto PatientToPatientOutDto(Patient patient);

  PatientDetails patientToPatientDetails(Patient patient, Set<FamiliarOutDto> familiars);
}
