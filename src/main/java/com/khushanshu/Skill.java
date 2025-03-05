package com.khushanshu;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int sId;

    @Column(name="Name")
    private String sName;

    @ManyToMany(cascade = CascadeType.ALL)

    //cascading does not fills the other join table
    private List<Employee> employees=new ArrayList<>();
    //zero or one or more skill can be possessed by zero,one or more employees
    //a new table skills_employees will be created

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
