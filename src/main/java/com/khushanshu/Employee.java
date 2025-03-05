package com.khushanshu;

import jakarta.persistence.*;

@Entity
@Table(name="Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int eId;

    @Column(name="Name")
    private String eName;

    @Column(name="Address")
    private Address address;

    @OneToOne(mappedBy = "employee", cascade=CascadeType.ALL)

    //cascading tells how the changes in parent entity will propagate in child (total 8 cascade types are there)


    //BI DIRECTIONAL as  mapping in laptop too
    //This will associate the employee table with laptop as one to one
    //Employee will have FK referencing to PK of Laptop

    private Laptop laptop;

    @ManyToOne
    @JoinColumn(name = "Department Id")
    private Department department;
    //this will have a FK referencing to PK of department


    //getters and setters

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", eName=" + eName +
                ", address=" + address +
                '}';
    }
}
