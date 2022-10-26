package com.training.openshift.controller;


import com.training.openshift.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService){
        this.personService=personService;
    }

    @GetMapping("/")
    ResponseEntity<List<String>> getAllpersons(){
        return ResponseEntity.ok(this.personService.getAllPersons());
    }

    @PostMapping ("/{name}")
    ResponseEntity<String> addperson(@PathVariable  String name){
        return ResponseEntity.ok(this.personService.addPerson(name));
    }

    @PostMapping ("/")
    ResponseEntity<String> addperson2(@RequestParam("name") String name){
        return ResponseEntity.ok(this.personService.addPerson(name));
    }
}
