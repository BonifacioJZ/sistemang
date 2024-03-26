package com.bonifacio.juarez.sistemang.controllers;

import com.bonifacio.juarez.sistemang.dtos.PatientInDto;
import com.bonifacio.juarez.sistemang.services.IPatientService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "api/v1/patients")
public class PatientController {

  private final IPatientService patientservice;

  @Autowired
  public PatientController(IPatientService patientservice) {

    this.patientservice = patientservice;

  }

  @RequestMapping(method = RequestMethod.GET, value = { "/", "" })
  public ResponseEntity<?> index() {
    var patients = patientservice.getAllPatients();
    return new ResponseEntity<>(patients, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST, value = { "/", "" })
  public ResponseEntity<?> store(@Valid @RequestBody PatientInDto patientInDto, BindingResult result) {
    if (result.hasErrors()) {
      return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
    }
    return null;
  }
}
