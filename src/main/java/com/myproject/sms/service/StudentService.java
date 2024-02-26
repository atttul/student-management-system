package com.myproject.sms.service;

import com.myproject.sms.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    long addStudent(Student student);

    long updateStudent(Student student);

    void deleteStudent(long studentId);
}
