package com.student.service;

import com.student.model.Student;
import com.student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;


    public List<Student> addUser(List<Student> student) {
        List<Student> students = studentRepo.saveAll(student);
        return students;
    }


}
