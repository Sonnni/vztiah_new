package com.example.vztiah.course.persistence;

import com.example.vztiah.osoba.persistence.OsobaEntity;
import com.example.vztiah.student.persistence.StudentEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class CourseEntity {
    @Id
    @GeneratedValue
    Long id;
    String name;
    @ManyToOne
    OsobaEntity osoba;
    @ManyToMany
    Set<StudentEntity> study;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OsobaEntity getOsoba() {
        return osoba;
    }

    public void setOsoba(OsobaEntity osoba) {
        this.osoba = osoba;
    }

    public Set<StudentEntity> getStudy() {
        return study;
    }

    public void setStudy(Set<StudentEntity> study) {
        this.study = study;
    }
}
