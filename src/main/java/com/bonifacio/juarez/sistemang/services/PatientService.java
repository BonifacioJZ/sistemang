package com.bonifacio.juarez.sistemang.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.bonifacio.juarez.sistemang.dtos.*;
import com.bonifacio.juarez.sistemang.repositories.FamiliarRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bonifacio.juarez.sistemang.entities.Patient;
import com.bonifacio.juarez.sistemang.repositories.PatientRepository;
import com.bonifacio.juarez.sistemang.mappers.IFamiliarMapper;

import com.bonifacio.juarez.sistemang.mappers.IPatientMapper;

@Component
public class PatientService implements IPatientService {

  private final PatientRepository patientRepository;
  private final IPatientMapper patientMapper;
  private final IFamiliarMapper familiarMapper;
  private final FamiliarRepository familiarRepository;
  @Autowired
  public PatientService(PatientRepository patientRepository, IPatientMapper patientMapper,
      IFamiliarMapper familiarMapper, FamiliarRepository familiarRepository) {
    this.patientMapper = patientMapper;
    this.patientRepository = patientRepository;
    this.familiarMapper = familiarMapper;
    this.familiarRepository = familiarRepository;
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
  public PatientDetails getPatientByCurp(String curp) {
    if (StringUtils.isEmpty(curp)) {
      return null;
    }
    var patient = patientRepository.findByCurp(curp);
    Set<FamiliarOutDto> familiars = new HashSet<FamiliarOutDto>();
    patient.getFamiliars().forEach(fam -> {
      familiars.add(familiarMapper.familiarToFamiliarOutDto(fam));
    });
    var out = patientMapper.patientToPatientDetails(patient, familiars);

    return out;
  }

  @Override
  public PatientDetails addFamiliarToPatient(AddFamiliar addFamiliar) {

    var patient = patientRepository.findByCurp(addFamiliar.getPatientCurp());
    if(patient == null){
      return null;
    }
    var familiar = familiarRepository.findByCurp(addFamiliar.getFamiliarCurp());
    if(familiar==null){
      return null;
    }
    patient.addFamiliar(familiar);
    patientRepository.save(patient);
    var outPatient = getPatientByCurp(patient.getCurp());
    return outPatient;
  }

}
