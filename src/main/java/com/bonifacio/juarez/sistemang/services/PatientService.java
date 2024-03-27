package com.bonifacio.juarez.sistemang.services;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bonifacio.juarez.sistemang.dtos.PatientInDto;
import com.bonifacio.juarez.sistemang.dtos.PatientOutDto;
import com.bonifacio.juarez.sistemang.entities.Patient;
import com.bonifacio.juarez.sistemang.repositories.PatientRepository;
import com.bonifacio.juarez.sistemang.mappers.IPatientMapper;

@Component
public class PatientService implements IPatientService {

  private final PatientRepository patientRepository;
  private final IPatientMapper patientMapper;

  @Autowired
  public PatientService(PatientRepository patientRepository, IPatientMapper patientMapper) {
    this.patientMapper = patientMapper;
    this.patientRepository = patientRepository;
  }

  @Override
  public Iterable<PatientOutDto> getAllPatients() {
    // TODO Auto-generated method stub
    var patients = patientRepository.findAll();
    ArrayList<PatientOutDto> out = new ArrayList<>();
    patients.forEach(patient -> {
      out.add(patientMapper.PatientToPatientOutDto(patient));
    });
    return out;
  }

  @Override
  public Patient savePatient(PatientInDto patientInDto) {
    var patientIn = patientMapper.PatientInDtotoPatient(patientInDto);
    patientIn.setCurp(patientIn.getCurp().toUpperCase());
    return patientRepository.save(patientIn);
  }

  @Override
  public PatientOutDto getPatientByCurp(String curp) {
    // TODO Auto-generated method stub
    if (StringUtils.isEmpty(curp)) {
      return null;
    }
    var patient = patientRepository.findByCurp(curp);
    var out = patientMapper.PatientToPatientOutDto(patient);
    return out;
  }

}
