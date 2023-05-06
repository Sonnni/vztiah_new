package com.example.vztiah.osoba.service;

import com.example.vztiah.osoba.persistence.OsobaEntity;
import com.example.vztiah.osoba.persistence.OsobaRepository;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
            o2.setEmail(o1.getEmail());
            o2.setPassword(o1.getPassword());
            vysledok.add(o2);
        }
        return vysledok;
    }
    @Transactional
    public void createPerson(OsobaDto osobaDto){
        OsobaEntity osobaEntity = new OsobaEntity();
        osobaEntity.setMeno(osobaDto.getMeno());
        osobaEntity.setPriezvisko(osobaDto.getPriezvisko());
        osobaEntity.setEmail(osobaDto.getEmail());
        osobaEntity.setPassword(osobaDto.getPassword());
        osobaRepository.save(osobaEntity);
    }
    private OsobaDto mapOsobaEntityToOsobaDto(OsobaEntity osobaEntity) {
        OsobaDto osobaDto = new OsobaDto();
        osobaDto.setId(osobaEntity.getId());
        osobaDto.setMeno(osobaEntity.getMeno());
        osobaDto.setPriezvisko(osobaEntity.getPriezvisko());
        osobaDto.setEmail(osobaEntity.getEmail());
        osobaDto.setPassword(osobaEntity.getPassword());
        return osobaDto;
    }
    @Override
    public OsobaDto updateOsoba(Long id, OsobaDto osobaDto) {
        Optional<OsobaEntity> osobaOptional = osobaRepository.findById(id);
        if (osobaOptional.isPresent()) {
            OsobaEntity osoba = osobaOptional.get();
            osoba.setMeno(osobaDto.getMeno());
            osoba.setPriezvisko(osobaDto.getPriezvisko());
            osoba.setEmail(osobaDto.getEmail());
            osoba.setPassword(osobaDto.getPassword());
            OsobaEntity updatedOsoba = osobaRepository.save(osoba);
            return mapOsobaEntityToOsobaDto(updatedOsoba);
        } else {
            return null;
        }
    }


    public void deleteOsoba (Long id) {
        osobaRepository.deleteById(id);
    }

}
