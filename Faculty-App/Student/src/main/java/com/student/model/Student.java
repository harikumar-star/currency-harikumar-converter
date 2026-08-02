package com.student.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"roll_no", "department"})
        }
)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "roll_no")
    private Long rollNo;
    private String name;
    //  @Column(unique = true)  only one column if you want to make unique
    private String department;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRollNo() {
        return rollNo;
    }

    public void setRollNo(Long rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
