package com.example.vztiah.osoba.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsobaRepository extends CrudRepository<OsobaEntity, Long> {

}
