package com.student.controller;


import com.student.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("StuAttend")
public class StudentAttendence {

    @Autowired
    AttendanceService attendanceService;

    @PostMapping
    public ResponseEntity<String> stuAttends(@RequestParam String type, @RequestParam Long number) {

        String status = attendanceService.studentAndFacultyRequest(type, number);
        if (status.equals("Student")) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Class Attended");
        }else if(status.equalsIgnoreCase("fac")){
            return ResponseEntity.status(HttpStatus.CREATED).body("Attendence Added");
        }

        return null;
    }

}
