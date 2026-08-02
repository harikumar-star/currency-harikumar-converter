package com.student.model;

import jakarta.persistence.*;

@Entity
@Table
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long faculty_refNo;
    private String facultyName;
    private String department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFaculty_refNo() {
        return faculty_refNo;
    }

    public void setFaculty_refNo(Long faculty_refNo) {
        this.faculty_refNo = faculty_refNo;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", faculty_refNo=" + faculty_refNo +
                ", facultyName='" + facultyName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
