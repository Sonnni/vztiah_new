package com.example.vztiah.course.persistence;

import com.example.vztiah.osoba.persistence.OsobaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository  extends CrudRepository<CourseEntity, Long> {

    @Query(value = "SELECT * FROM course_entity WHERE osoba_id=:osobaId", nativeQuery = true)
    public List<CourseEntity> findByOsobaId(Long osobaId);

}
