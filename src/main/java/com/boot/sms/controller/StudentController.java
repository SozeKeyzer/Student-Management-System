package com.boot.sms.controller;

import com.boot.sms.entity.Student;
import com.boot.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    //handler methods to handle the requests
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        //creating student obj to store student form data (basically to bind data)
        Student student=new Student();
        model.addAttribute("student",student);
        return "create_student";
    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student")Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable("id")Long id,Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") Long id,@ModelAttribute("student")Student student,Model model){
        //get student from database by id
        Student existingStudent=studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        //save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }
    @GetMapping("/students/remove/{id}")
    public String removeStudent(@PathVariable Long id){
        Student student=studentService.getStudentById(id);
        studentService.deleteStudent(student);
        return "redirect:/students";
    }
}
