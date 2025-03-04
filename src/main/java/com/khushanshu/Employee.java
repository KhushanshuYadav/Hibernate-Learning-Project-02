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

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", eName=" + eName +
                ", address=" + address +
                '}';
    }
}
