package com.student.service;

import com.student.exception.DatabaseOperationException;
import com.student.exception.DuplicateStudentException;
import com.student.model.Faculty;
import com.student.repo.FacultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepo facultyRepo;

    public List<Faculty> addFaculty(List<Faculty> facultyList) {

        try {
            List<Faculty> list = facultyRepo.saveAll(facultyList);
            return list;
        } catch (DataIntegrityViolationException d) {
            throw new DuplicateStudentException("Duplicates Data in Faculty Insertion !");
        } catch (DataAccessException d) {
            throw new DatabaseOperationException("Facultu Could not Inserted");
        }

    }

}
