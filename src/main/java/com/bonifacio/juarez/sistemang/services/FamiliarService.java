package com.bonifacio.juarez.sistemang.services;

import com.bonifacio.juarez.sistemang.dtos.FamiliarDetails;
import com.bonifacio.juarez.sistemang.dtos.FamiliarIntDto;
import com.bonifacio.juarez.sistemang.dtos.FamiliarOutDto;
import com.bonifacio.juarez.sistemang.dtos.PatientOutDto;
import com.bonifacio.juarez.sistemang.entities.Familiar;
import com.bonifacio.juarez.sistemang.mappers.IFamiliarMapper;
import com.bonifacio.juarez.sistemang.mappers.IPatientMapper;
import com.bonifacio.juarez.sistemang.repositories.FamiliarRepository;
import com.bonifacio.juarez.sistemang.repositories.PatientRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FamiliarService implements IFamiliarService {

  private final FamiliarRepository familiarRepository;
  private final IFamiliarMapper familiarMapper;
  private final PatientRepository patientRepository;
  private final IPatientMapper patientMapper;
  @Autowired
  public FamiliarService(FamiliarRepository familiarRepository, IFamiliarMapper familiarMapper,
      PatientRepository patientRepository, IPatientMapper patientMapper) {
    this.familiarMapper = familiarMapper;
    this.familiarRepository = familiarRepository;
    this.patientRepository = patientRepository;
    this.patientMapper = patientMapper;
  }

  @Override
  public Iterable<FamiliarOutDto> getAllFamiliars() {
    var familiars = familiarRepository.findAll();
    ArrayList<FamiliarOutDto> out = new ArrayList<>();

    familiars.forEach(familiar -> {
      out.add(familiarMapper.familiarToFamiliarOutDto(familiar));
    });
    return out;
  }

  @Override
  public Familiar saveFamiliar(FamiliarIntDto familiarIntDto) {

    var familiar = familiarMapper.FamiliarInDtoToFamiliar(familiarIntDto);
    var patient = patientRepository.findByCurp(familiarIntDto.getPatient_curp());
    if (patient == null) {
      return null;
    }
    familiar.addPatient(patient);
    familiarRepository.save(familiar);
    return familiar;
  }

  @Override
  public FamiliarDetails getFamiliarByCurp(String curp) {
    if(StringUtils.isEmpty(curp)){
      return null;
    }
    var patient = familiarRepository.findByCurp(curp);
    Set<PatientOutDto> patients = new HashSet<>();
    patient.getPatients().forEach(p->{
      patients.add(patientMapper.PatientToPatientOutDto(p));
    });
    var out = familiarMapper.familiarToFamiliarDetails(patient,patients);
    return out;
  }

}
