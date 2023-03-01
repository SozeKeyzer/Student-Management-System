package com.boot.sms.service;

import com.boot.sms.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student updateStudent(Student student);
    Student getStudentById(Long id);

    Student saveStudent(Student student);

    void deleteStudent(Student student);
}
