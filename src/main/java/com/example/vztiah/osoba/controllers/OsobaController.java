package com.example.vztiah.osoba.controllers;

import com.example.vztiah.osoba.persistence.OsobaRepository;
import com.example.vztiah.osoba.service.OsobaDto;
import com.example.vztiah.osoba.service.OsobaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
//    @DeleteMapping("/api/osoba{osobaId}")
//    public void deleteOsoba(@PathVariable Long osobaId) {
//        System.out.println("Delete teacher: ID = " + osobaId);
//        osobaService.deleteOsoba(osobaId);
//    }

    @DeleteMapping("/{id}")
    public void deleteOsoba(@PathVariable Long id) {
        osobaService.deleteOsoba(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OsobaDto> updateOsoba(@PathVariable Long id, @RequestBody OsobaDto osobaDto) {
        OsobaDto updatedOsobaDto = osobaService.updateOsoba(id, osobaDto);
        if (updatedOsobaDto != null) {
            return new ResponseEntity<>(updatedOsobaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
