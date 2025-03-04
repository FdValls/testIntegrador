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
import com.integrador.summary.utils.ApiResponse;

@RestController
@RequestMapping("/swapi")
public class SwapiRestController {

    @Autowired
    private SwapiService swapiService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/people")
    public ResponseEntity<?> getPeople() {
        return ResponseEntity.ok().body(new ApiResponse("ok", swapiService.getAllData()));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/peopleFromDB")
    public ResponseEntity<?> getPeopleFromDB() {
        return ResponseEntity.ok().body(new ApiResponse("ok", swapiService.getAllDataFromDB()));
    }

    @PostMapping("/people/create")
    public ResponseEntity<?> postPeople(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(new ApiResponse("ok", swapiService.createNewPerson(person)));
    }

    @DeleteMapping("/people/delete/{idPerson}")
    public void deletePeople(@PathVariable Long idPerson) {
        swapiService.deletePerson(idPerson);
       ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
