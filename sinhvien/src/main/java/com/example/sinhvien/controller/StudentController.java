package com.example.sinhvien.controller;


import com.example.sinhvien.dto.StudentCreationRequest;
import com.example.sinhvien.dto.StudentUpdateRequest;
import com.example.sinhvien.entity.Student;
import com.example.sinhvien.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    Student createStudent(@RequestBody StudentCreationRequest request){
        return studentService.createStudent(request);
    }

    @GetMapping
    List<Student> getStudents(){
        return studentService.getStudents();

    }
        
    

    @GetMapping("/{id}")
    Student getStudent(@PathVariable("id") String id){
        return studentService.getStudent(id);
    }

    @PutMapping("/{id}")
    Student updateStudent(@PathVariable String id, @RequestBody StudentUpdateRequest request){
        return studentService.updateStudent(id, request);
    }

    @DeleteMapping("/{id}")
    String deleteStudent(@PathVariable String id){
        studentService.deleteStudent(id);
        return "User has been deleted";
    }
}
