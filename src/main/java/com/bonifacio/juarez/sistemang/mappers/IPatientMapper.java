package com.bonifacio.juarez.sistemang.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IPatientMapper {
    IPatientMapper INSTANCE = Mappers.getMapper(IPatientMapper.class);
}
