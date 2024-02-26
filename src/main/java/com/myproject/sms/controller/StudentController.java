package com.myproject.sms.controller;

import com.myproject.sms.entity.Student;
import com.myproject.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String indexPage(){
        return "/index";
    }

    @GetMapping("/students")
    public String getAllStudents(Model model){

        List<Student> students=studentService.getAllStudents();
        model.addAttribute("students",students);
        return "students";
    }
    @PostMapping("/index")
    public String addStudent(@ModelAttribute Student student){

        long studentId=studentService.addStudent(student);
        System.out.println(student.getFirstName());
        return "students";
    }
    @PutMapping
    public String updateStudent(Student student){
        long studentId=studentService.updateStudent(student);
        return "/students";
    }
    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable("studentId") long studentId){
        studentService.deleteStudent(studentId);
        return "students";
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