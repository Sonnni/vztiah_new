package com.example.vztiah.course.service;

import com.example.vztiah.course.persistence.CourseEntity;
import com.example.vztiah.course.persistence.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseService {

    CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDto> getCoursesForTeacher(Long osobaId) {
        List<CourseEntity> courses = courseRepository.findByOsobaId(osobaId);
        List<CourseDto> result = new ArrayList<>();
        for (CourseEntity c : courses) {
            CourseDto c2 = new CourseDto();
            c2.setId(c.getId());
            c2.setName(c.getName());
            result.add(c2);
        }
        return result;
    }

}
