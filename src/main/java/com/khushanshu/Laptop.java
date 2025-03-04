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

    @Override
    public String toString() {
        return "Laptop{" +
                "lId=" + lId +
                ", lBrand=" + lBrand +
                '}';
    }
}
