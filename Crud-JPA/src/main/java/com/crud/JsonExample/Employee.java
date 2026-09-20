package com.crud.JsonExample;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int id;
    private String name;
    private String department;
    private Address address;
    List<Integer> lsit = new ArrayList();


    public List getLsit() {
        return lsit;
    }

    public void setLsit(List lsit) {

        this.lsit = lsit;

    }

    // Constructors
    public Employee() {}

    public Employee(int id, String name, String department, Address address,List<Integer> list) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.address = address;
        this.lsit = list;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
}
