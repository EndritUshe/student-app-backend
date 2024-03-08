package com.endritushe.studentweb.controller;


import com.endritushe.studentweb.model.Student;

import com.endritushe.studentweb.service.StudentServiceImp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {


    private final StudentServiceImp studentServiceImp;

    public StudentController(StudentServiceImp studentServiceImp){
        this.studentServiceImp = studentServiceImp;
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return this.studentServiceImp.saveStudent(student);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return this.studentServiceImp.findAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student findStudentById(@PathVariable Integer id){
        return this.studentServiceImp.findStudentById(id);
    }




}
