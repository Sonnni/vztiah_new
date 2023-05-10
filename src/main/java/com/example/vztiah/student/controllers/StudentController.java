package com.example.vztiah.student.controllers;

import com.example.vztiah.student.service.StudentDto;
import com.example.vztiah.student.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    StudentService studentService;

    public StudentController (StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/allStudent")
    public List<StudentDto> listAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping("/newStudent")
    public void createStudent(@RequestBody StudentDto student){
        studentService.createStudent(student);
    }


}
