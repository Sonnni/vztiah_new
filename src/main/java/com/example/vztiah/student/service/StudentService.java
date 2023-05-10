package com.example.vztiah.student.service;

import com.example.vztiah.student.persistence.StudentEntity;
import com.example.vztiah.student.persistence.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository;
    public StudentService (StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public List<StudentDto> getAllStudent(){
        Iterable<StudentEntity> studenty = studentRepository.findAll();
        List<StudentDto> vysledok = new ArrayList<>();
        //kopia
        for (StudentEntity o1 : studenty){
            StudentDto o2 = new StudentDto();
            o2.setId(o1.getId());
            o2.setMeno(o1.getMeno());
            o2.setPriezvisko(o1.getPriezvisko());
            //o2.setEmailParenta(o1.getEmail_parenta());
            vysledok.add(o2);
        }
        return vysledok;
    }
    @Transactional
    public void createStudent(StudentDto studentDto){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setMeno(studentDto.getMeno());
        studentEntity.setPriezvisko(studentDto.getPriezvisko());
        //studentEntity.setEmail_parenta(studentDto.getEmailParenta());
        studentRepository.save(studentEntity);
    }

}
