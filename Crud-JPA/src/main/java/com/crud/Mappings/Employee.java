package com.crud.Mappings;

import java.util.List;

public class Employee {

    private int id;
    private List<String> cds;

    public Employee(int id, List<String> cds) {
        this.id = id;
        this.cds = cds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getCds() {
        return cds;
    }

    public void setCds(List<String> cds) {
        this.cds = cds;
    }
}
