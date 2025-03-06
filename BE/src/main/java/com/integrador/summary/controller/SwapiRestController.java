package com.integrador.summary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.summary.model.Person;
import com.integrador.summary.service.SwapiService;
import com.integrador.summary.swapiDTO.SwapiDTO;
import com.integrador.summary.utils.ApiResponse;


import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.*;

@RestController
@RequestMapping("/swapi")
public class SwapiRestController {

    @Autowired
    private SwapiService swapiService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/people")
    public ResponseEntity<?> getPeople() {
        return ResponseEntity.ok().body(new ApiResponse("ok", swapiService.getAllData(), "N/A"));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/peopleFromDB")
    @Operation(summary = "Obtenemos todos los registros desde la DB H2", description = "Obtenemos registros almacenados manualmente en la db desde un endpoint externo")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200", 
            description = "Successful Operation", 
            content = @Content(schema = @Schema(
                implementation = SwapiDTO.class))),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "404",
            description = "Users not found",
            content = @Content(schema = @Schema(
                implementation = ApiResponse.class
        )))
    })
    public ResponseEntity<?> getPeopleFromDB() {
        return ResponseEntity.ok().body(new ApiResponse("ok", swapiService.getAllDataFromDB(), "N/A"));
    }

    @PostMapping("/people/create")
    public ResponseEntity<?> postPeople(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(new ApiResponse("ok", swapiService.createNewPerson(person), "N/A"));
    }

    @DeleteMapping("/people/delete/{idPerson}")
    @Operation(summary = "Borrar un usuario de la DB", description = "Borra un usuario por su ID")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
        responseCode = "204", 
        description = "User deleted",
        content = @Content(schema = @Schema(
                implementation = ApiResponse.class))),
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
        responseCode = "404", 
        description = "User not found",
        content = @Content(schema = @Schema(
            implementation = ApiResponse.class 
            )))
        })
    public ResponseEntity<?> deletePeople(@PathVariable Long idPerson) {
        SwapiDTO showObject = this.swapiService.findById(idPerson);
        swapiService.deletePerson(idPerson);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse("User delete", showObject, "N/A"));
    }

}
