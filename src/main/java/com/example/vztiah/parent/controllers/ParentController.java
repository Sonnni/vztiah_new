package com.example.vztiah.parent.controllers;

import com.example.vztiah.parent.service.ParentDto;
import com.example.vztiah.parent.service.ParentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParentController {
    ParentService parentService;

    public ParentController(ParentService parentService){
        this.parentService = parentService;
    }
    @GetMapping("/allParent")
    public List<ParentDto> listAllParent(){
        return parentService.getAllParent();
    }

    @PostMapping("/newParent")
    public void createParent(@RequestBody ParentDto parent){
        parentService.createParent(parent);
    }
    @DeleteMapping("/parent/{id}")
    public void deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
    }
}
