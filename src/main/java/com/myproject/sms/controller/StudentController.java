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

//----------------------------------------------------------------------------------------------------------------------
//Getting List of All Students
    @GetMapping("/students")
    public String getAllStudents(Model model){
        List<Student> studentsList=studentService.getAllStudents();
        model.addAttribute("students",studentsList);
        return "students";
    }

//----------------------------------------------------------------------------------------------------------------------
//Adding New Student
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

//----------------------------------------------------------------------------------------------------------------------
//Updating Existing Student
    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable("id") long id, Model model){
        model.addAttribute("studentedit", studentService.getStudentById(id));
        return "edit_student";
    }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") long id, @ModelAttribute Student student){
        //1. Get existing student by id
        Student existingStudent=studentService.getStudentById(id);

        //2. Setting new values which we get from the user
        existingStudent.setId(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        //3. Adding this updated details to DB
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

//----------------------------------------------------------------------------------------------------------------------
//Deleting existing Student
    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable("id") long studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }
}
