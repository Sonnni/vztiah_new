package com.example.vztiah.course.controllers;

import com.example.vztiah.course.service.CourseDto;
import com.example.vztiah.course.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/course/{osobaId}")
    public List<CourseDto> getCoursesForTeacher(@PathVariable Long osobaId) {
        return courseService.getCoursesForTeacher(osobaId);
    }


}
