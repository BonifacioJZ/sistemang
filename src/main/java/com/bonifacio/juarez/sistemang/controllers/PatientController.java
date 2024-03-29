package com.bonifacio.juarez.sistemang.controllers;

import com.bonifacio.juarez.sistemang.dtos.AddFamiliar;
import com.bonifacio.juarez.sistemang.dtos.PatientInDto;
import com.bonifacio.juarez.sistemang.entities.Patient;
import com.bonifacio.juarez.sistemang.services.IPatientService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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

    Patient patient = patientservice.savePatient(patientInDto);

    if (patient == null) {
      return new ResponseEntity<>("error al guardar el paciente", HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(patient, HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.GET, value = { "/{curp}/", "/{curp}" })
  public ResponseEntity<?> show(@PathVariable String curp) {

    var patient = patientservice.getPatientByCurp(curp);

    if (patient == null) {
      return new ResponseEntity<>("el usuario con la curp " + curp + " no existe", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(patient, HttpStatus.OK);
  }
  @RequestMapping(method = RequestMethod.POST,value = {"add/","add"})
  public ResponseEntity<?> addFamiliarToPatient(@Valid @RequestBody AddFamiliar addFamiliar,BindingResult result){
    if(result.hasErrors()){
      return new ResponseEntity<>(result.getAllErrors(),HttpStatus.BAD_REQUEST);
    }
    var patient = patientservice.addFamiliarToPatient(addFamiliar);
    if(patient==null){
      return new ResponseEntity<>("Error al guardar la informacion",HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(patient,HttpStatus.OK);
  }
}
