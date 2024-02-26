package com.myproject.sms.controller;

import com.myproject.sms.entity.Student;
import com.myproject.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students=studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Long> addStudent(@RequestBody Student student){
        long studentId=studentService.addStudent(student);
        return new ResponseEntity<>(studentId, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Long> updateStudent(Student student){
        long studentId=studentService.updateStudent(student);
        return new ResponseEntity<>(studentId, HttpStatus.OK);
    }
    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") long studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}


/*
{
        "id": 3,
        "firstName": "Akash",
        "lastName": "Atul",
        "email": "akashtul1@gmail.com"
}
 */