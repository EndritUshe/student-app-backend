package com.endritushe.studentweb.service;

import com.endritushe.studentweb.exceptions.StudentNotFoundException;
import com.endritushe.studentweb.model.Student;
import com.endritushe.studentweb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentServiceImp{


    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student){
        return this.studentRepository.save(student);
    }

    public List<Student> findAllStudents(){
        return this.studentRepository.findAll();
    }

    public Student findStudentById(Integer id){
        Optional<Student> foundStudent = studentRepository.findById(id);
      if(foundStudent.isPresent()){
          return foundStudent.get();
      }
      else {
          throw new StudentNotFoundException("Student with id: " + id + " was not found!");
      }
    }


}
