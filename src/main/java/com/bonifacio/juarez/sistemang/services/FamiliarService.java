package com.bonifacio.juarez.sistemang.services;


import com.bonifacio.juarez.sistemang.repositories.FamiliarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FamiliarService implements IFamiliarService{

    private final FamiliarRepository familiarRepository;
    @Autowired
    public FamiliarService(FamiliarRepository familiarRepository){
        this.familiarRepository = familiarRepository;
    }

}