package com.example.vztiah.student.persistence;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class StudentEntity {
    String meno;
    String priezvisko;
    String email_parenta;
    @Id
            @GeneratedValue
    Long id;

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

    public String getEmail_parenta() {
        return email_parenta;
    }

    public void setEmail_parenta(String email_parenta) {
        this.email_parenta = email_parenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
