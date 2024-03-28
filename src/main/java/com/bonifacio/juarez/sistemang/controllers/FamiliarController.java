package com.bonifacio.juarez.sistemang.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bonifacio.juarez.sistemang.dtos.FamiliarIntDto;
import com.bonifacio.juarez.sistemang.services.IFamiliarService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

/**
 * FamiliarController
 */
@RestController
@RequestMapping(name = "Familiars", value = "api/v1/familiars")
public class FamiliarController {

  private final IFamiliarService familiarService;

  public FamiliarController(IFamiliarService familiarService) {
    this.familiarService = familiarService;
  }

  @RequestMapping(method = RequestMethod.GET, name = "getAll Familiars", value = { "", "/" })
  public ResponseEntity<?> index() {

    var familiars = familiarService.getAllFamiliars();
    return new ResponseEntity<>(familiars, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST, name = "Save Familiar", value = { "", "/" })
  @Transactional
  public ResponseEntity<?> store(@Valid @RequestBody FamiliarIntDto familiarIntDto,
      BindingResult result) {

    if (result.hasErrors()) {
      return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
    }
    var familiar = familiarService.saveFamiliar(familiarIntDto);
    if (familiar == null) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(familiar, HttpStatus.CREATED);
  }

}
