package com.student.controller;

import com.student.model.Student;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("students")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<List<Student>> student(@RequestBody List<Student> student) {
        List<Student> students = studentService.addUser(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(students);
    }


}
