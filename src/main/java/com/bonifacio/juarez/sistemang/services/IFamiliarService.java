package com.bonifacio.juarez.sistemang.services;

import com.bonifacio.juarez.sistemang.dtos.FamiliarDetails;
import com.bonifacio.juarez.sistemang.dtos.FamiliarIntDto;
import com.bonifacio.juarez.sistemang.dtos.FamiliarOutDto;
import com.bonifacio.juarez.sistemang.entities.Familiar;

public interface IFamiliarService {

  Iterable<FamiliarOutDto> getAllFamiliars();

  Familiar saveFamiliar(FamiliarIntDto familiarIntDto);

  FamiliarDetails getFamiliarByCurp(String curp);
}
