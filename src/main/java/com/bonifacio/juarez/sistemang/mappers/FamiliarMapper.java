package com.bonifacio.juarez.sistemang.mappers;

import com.bonifacio.juarez.sistemang.dtos.FamiliarDetails;
import com.bonifacio.juarez.sistemang.dtos.PatientOutDto;
import org.springframework.stereotype.Component;

import com.bonifacio.juarez.sistemang.dtos.FamiliarIntDto;
import com.bonifacio.juarez.sistemang.dtos.FamiliarOutDto;
import com.bonifacio.juarez.sistemang.entities.Familiar;

import java.util.Set;

@Component
public class FamiliarMapper implements IFamiliarMapper {

  @Override
  public FamiliarOutDto familiarToFamiliarOutDto(Familiar familiar) {

    if (familiar == null)
      return null;

    FamiliarOutDto out = new FamiliarOutDto(familiar.getId(), familiar.getName(), familiar.getLastName(),
        familiar.getPhone(), familiar.getEmail(), familiar.getColony(), familiar.getCity(),
        familiar.getAddress(), familiar.getCurp(), familiar.getBirthday());

    return out;
  }

  @Override
  public Familiar FamiliarInDtoToFamiliar(FamiliarIntDto familiarIntDto) {
    if (familiarIntDto == null)
      return null;
    Familiar out = new Familiar(familiarIntDto.getName(), familiarIntDto.getLastName(),
        familiarIntDto.getPhone(), familiarIntDto.getEmail(), familiarIntDto.getColony(),
        familiarIntDto.getCity(), familiarIntDto.getBirthday(), familiarIntDto.getAddress(),
        familiarIntDto.getCurp().toUpperCase());
    return out;
  }

  @Override
  public FamiliarDetails familiarToFamiliarDetails(Familiar familiar, Set<PatientOutDto> patients) {
    if (familiar == null) {
      return null;
    }
    FamiliarDetails out = new FamiliarDetails(familiar.getId(),familiar.getName(),familiar.getLastName(),
            familiar.getPhone(),familiar.getEmail(),familiar.getColony(),familiar.getCity(),
            familiar.getAddress(),familiar.getAddress(),familiar.getBirthday(),
            patients);
    return out;
  }
}
