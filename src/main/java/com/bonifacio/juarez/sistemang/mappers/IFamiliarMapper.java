package com.bonifacio.juarez.sistemang.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IFamiliarMapper {
    IFamiliarMapper INSTANCE = Mappers.getMapper(IFamiliarMapper.class);

}
