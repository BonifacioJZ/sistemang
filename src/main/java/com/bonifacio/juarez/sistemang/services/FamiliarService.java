package com.bonifacio.juarez.sistemang.services;

import com.bonifacio.juarez.sistemang.dtos.FamiliarIntDto;
import com.bonifacio.juarez.sistemang.dtos.FamiliarOutDto;
import com.bonifacio.juarez.sistemang.entities.Familiar;
import com.bonifacio.juarez.sistemang.mappers.IFamiliarMapper;
import com.bonifacio.juarez.sistemang.repositories.FamiliarRepository;
import com.bonifacio.juarez.sistemang.repositories.PatientRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FamiliarService implements IFamiliarService {

  private final FamiliarRepository familiarRepository;
  private final IFamiliarMapper familiarMapper;
  private final PatientRepository patientRepository;

  @Autowired
  public FamiliarService(FamiliarRepository familiarRepository, IFamiliarMapper familiarMapper,
      PatientRepository patientRepository) {
    this.familiarMapper = familiarMapper;
    this.familiarRepository = familiarRepository;
    this.patientRepository = patientRepository;
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

}
