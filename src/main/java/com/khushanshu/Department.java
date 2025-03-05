package com.khushanshu;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//one department -> many employees

@Entity
@Table(name="Departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int dId;

    @Column(name="Name")
    private String dName;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees=new ArrayList<>();

    //"mappedBy" will avoid extra table


    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                '}';
    }
}
