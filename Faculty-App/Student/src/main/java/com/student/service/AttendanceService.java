package com.student.service;


import com.student.model.Attendance;
import com.student.repo.AttendanceRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    @Autowired
    AttendanceRepo attendanceRepo;


    public String studentAndFacultyRequest(String type, Long number) {
        if (type.equalsIgnoreCase("stu")) {
            Attendance attendance = studentRequest(number);
            if (attendance.getStatus().equals("Pending") && attendance.getStuRollno() != null) {
                return "Student";
            }
        } else {
            String get =facultyLogic(number);
            return get;
        }
        return null;
    }

    public Attendance studentRequest(Long stuRollno) {
        Attendance attendance = new Attendance();
        attendance.setStuRollno(stuRollno);
        attendance.setStatus("Pending");
        return attendanceRepo.save(attendance);
    }

    @Transactional
    public String facultyLogic(Long facultyRef) {
        List<Attendance> attendanceList = getAttendence();

        List<Long> idsToUpdate = attendanceList.stream()
                .filter(status -> "Pending".equals(status.getStatus())) // example condition
                .map(Attendance::getId)
                .toList();
// 2. Fire ONE single update query for all matching records
        if (!idsToUpdate.isEmpty()) {
            attendanceRepo.updateStatusForIds("PROCESSED", facultyRef,idsToUpdate);
        }
        return "fac";
    }

    public List<Attendance> getAttendence() {
        List<Attendance> attendancesList = attendanceRepo.findAll();
        return attendancesList;
    }


}
