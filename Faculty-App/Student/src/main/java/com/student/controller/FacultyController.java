package com.student.controller;

import com.student.model.Faculty;
import com.student.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;


    @PostMapping
    public ResponseEntity<List<Faculty>> faculty(@RequestBody List<Faculty> faculty) {

        List<Faculty> facultyList = facultyService.addFaculty(faculty);

        return ResponseEntity.status(HttpStatus.CREATED).body(facultyList);
    }


}
