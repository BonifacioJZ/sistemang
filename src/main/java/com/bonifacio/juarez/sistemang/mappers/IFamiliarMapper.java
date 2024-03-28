package com.bonifacio.juarez.sistemang.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bonifacio.juarez.sistemang.dtos.FamiliarIntDto;
import com.bonifacio.juarez.sistemang.dtos.FamiliarOutDto;
import com.bonifacio.juarez.sistemang.entities.Familiar;

@Mapper
public interface IFamiliarMapper {
  IFamiliarMapper INSTANCE = Mappers.getMapper(IFamiliarMapper.class);

  FamiliarOutDto familiarToFamiliarOutDto(Familiar familiar);

  Familiar FamiliarInDtoToFamiliar(FamiliarIntDto familiarIntDto);
}
