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

//    @GetMapping
//    public String indexPage(){
//        return "/index";
//    }

    @GetMapping("/students")
    public String getAllStudents(Model model){
        List<Student> studentsList=studentService.getAllStudents();
        model.addAttribute("students",studentsList);
        return "students";
    }

    //Create a handler method
    @GetMapping("/students/new")
    public String handleEmptyStudent(Model model){
        Student std=new Student();
        model.addAttribute("studentObject",std);
        return "create_student";
    }

    @PostMapping("/students")
    public String addStudent(@ModelAttribute("studentObject") Student student){
        studentService.addStudent(student);
        return "redirect:/students";
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