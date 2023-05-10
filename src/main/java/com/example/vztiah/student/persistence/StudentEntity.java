package com.example.vztiah.student.persistence;

import com.example.vztiah.course.persistence.CourseEntity;
import com.example.vztiah.parent.persistence.ParentEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class StudentEntity {
    String meno;
    String priezvisko;
    //String email_parenta;
    @Id
    @GeneratedValue
    Long id;
    @ManyToMany
    Set<CourseEntity> studyCourse;
    @ManyToOne
    ParentEntity parent;

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

//    public String getEmail_parenta() {
//        return email_parenta;
//    }
//
//    public void setEmail_parenta(String email_parenta) {
//        this.email_parenta = email_parenta;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CourseEntity> getStudyCourse() {
        return studyCourse;
    }

    public void setStudyCourse(Set<CourseEntity> studyCourse) {
        this.studyCourse = studyCourse;
    }

    public ParentEntity getParent() {
        return parent;
    }

    public void setParent(ParentEntity parent) {
        this.parent = parent;
    }
}
