package com.khushanshu;

import jakarta.persistence.*;

@Entity
@Table(name="Laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int lId;

    @Column(name="Brand")
    private String lBrand;

    @OneToOne(mappedBy = "laptop")
    //mappedBy tells to Laptop that mapping is handled by laptop col i.e FK in target i.e Employee so no need to create an extra column of FK here
    //we can do same in Employee in too but NOT IN BOTH
    //BI DIRECTIONAL
    //now laptop will also have FK referring to PK of employee
    //Laptops is now aware of employee
    private Employee employee;


    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getlBrand() {
        return lBrand;
    }

    public void setlBrand(String lBrand) {
        this.lBrand = lBrand;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lId=" + lId +
                ", lBrand=" + lBrand +
                '}';
    }
}
