package com.example.vztiah.osoba.service;

import com.example.vztiah.osoba.persistence.OsobaEntity;
import com.example.vztiah.osoba.persistence.OsobaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OsobaService {

    OsobaRepository osobaRepository;

    public OsobaService(OsobaRepository osobaRepository) {
        this.osobaRepository = osobaRepository;
    }

    public List<OsobaDto> getAllPersons(){
        Iterable<OsobaEntity> osoby = osobaRepository.findAll();
        List<OsobaDto> vysledok = new ArrayList<>();
        //kopia
        for (OsobaEntity o1 : osoby){
            OsobaDto o2 = new OsobaDto();
            o2.setId(o1.getId());
            o2.setMeno(o1.getMeno());
            o2.setPriezvisko(o1.getPriezvisko());
            vysledok.add(o2);
        }
        return vysledok;
    }
@Transactional
    public void createPerson(OsobaDto osobaDto){
        OsobaEntity osobaEntity = new OsobaEntity();
        osobaEntity.setMeno(osobaDto.getMeno());
        osobaEntity.setPriezvisko(osobaDto.getPriezvisko());
        osobaRepository.save(osobaEntity);
    }
}
