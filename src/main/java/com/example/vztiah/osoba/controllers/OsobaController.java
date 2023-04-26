package com.example.vztiah.osoba.controllers;

import com.example.vztiah.osoba.persistence.OsobaRepository;
import com.example.vztiah.osoba.service.OsobaDto;
import com.example.vztiah.osoba.service.OsobaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OsobaController {
    OsobaService osobaService;

    public OsobaController(OsobaService osobaService) {
        this.osobaService = osobaService;
    }

    @GetMapping("/all")
    public List<OsobaDto> listAllPerson(){
        return osobaService.getAllPersons();
    }

    @PostMapping("/newPerson")
    public void createPerson(@RequestBody OsobaDto osoba){
        osobaService.createPerson(osoba);
    }

}
