package com.example.vztiah.parent.service;

import com.example.vztiah.parent.persistence.ParentEntity;
import com.example.vztiah.parent.persistence.ParentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParentService {
    ParentRepository parentRepository;
    public ParentService(ParentRepository parentRepository){
        this.parentRepository = parentRepository;
    }
    public List<ParentDto> getAllParent(){
        Iterable<ParentEntity> parents = parentRepository.findAll();
        List<ParentDto> vysledok = new ArrayList<>();
        for (ParentEntity o1 : parents){
            ParentDto o2 = new ParentDto();
            o2.setId(o1.getId());
            o2.setMeno(o1.getMeno());
            o2.setPriezvisko(o1.getPriezvisko());
            o2.setEmailParent(o1.getEmailParent());
            o2.setPassword(o1.getPassword());
            vysledok.add(o2);
        }
        return vysledok;
    }
    @Transactional
    public void createParent(ParentDto parentDto){
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setMeno(parentDto.getMeno());
        parentEntity.setPriezvisko(parentDto.getPriezvisko());
        parentEntity.setEmailParent(parentDto.getEmailParent());
        parentEntity.setPassword(parentDto.getPassword());
        parentRepository.save(parentEntity);
    }

    @Transactional
    public void deleteParent (Long id) {
        parentRepository.deleteById(id);
    }
}
