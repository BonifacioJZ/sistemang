package com.bonifacio.juarez.sistemang.services;

import com.bonifacio.juarez.sistemang.entities.Patient;
import com.bonifacio.juarez.sistemang.repositories.PatientRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
@Component
public class PatientService implements IPatientService{
    public   final PatientRepository patientRepository;
    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

}
