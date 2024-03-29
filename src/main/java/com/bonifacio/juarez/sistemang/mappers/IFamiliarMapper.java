package com.bonifacio.juarez.sistemang.mappers;

import com.bonifacio.juarez.sistemang.dtos.FamiliarDetails;
import com.bonifacio.juarez.sistemang.dtos.PatientOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bonifacio.juarez.sistemang.dtos.FamiliarIntDto;
import com.bonifacio.juarez.sistemang.dtos.FamiliarOutDto;
import com.bonifacio.juarez.sistemang.entities.Familiar;

import java.util.Set;

@Mapper
public interface IFamiliarMapper {
  IFamiliarMapper INSTANCE = Mappers.getMapper(IFamiliarMapper.class);

  FamiliarOutDto familiarToFamiliarOutDto(Familiar familiar);

  Familiar FamiliarInDtoToFamiliar(FamiliarIntDto familiarIntDto);

  FamiliarDetails familiarToFamiliarDetails(Familiar familiar , Set<PatientOutDto> patients);
}
