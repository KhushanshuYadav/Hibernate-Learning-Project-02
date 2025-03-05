package com.khushanshu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello");



        SessionFactory sf= new Configuration().configure().addAnnotatedClass(com.khushanshu.Employee.class).addAnnotatedClass(com.khushanshu.Laptop.class).addAnnotatedClass(com.khushanshu.Department.class).buildSessionFactory();
        Session session=sf.openSession();

        Department d1=new Department();
        d1.setdName("IT");

        Department d2=new Department();
        d2.setdName("Sales");


        Laptop l1=new Laptop();
        l1.setlBrand("Apple");

        Laptop l2=new Laptop();
        l2.setlBrand("HP");

        Laptop l3=new Laptop();
        l3.setlBrand("Lenovo");


        Address a1=new Address();
        a1.setCity("Indore");
        a1.setPinCode("452010");
        a1.setState("M.P");

        Address a2=new Address();
        a2.setCity("Kolkata");
        a2.setPinCode("210201");
        a2.setState("W.B.");

        Address a3=new Address();
        a3.setCity("Mumbai");
        a3.setPinCode("850963");
        a3.setState("M.H.");


        Employee e1=new Employee();
        e1.seteName("Ram Singh");
        e1.setAddress(a1);
        e1.setLaptop(l1);
        e1.setDepartment(d1);

        Employee e2=new Employee();
        e2.seteName("Meera Singh");
        e2.setAddress(a2);
        e2.setLaptop(l2);
        e2.setDepartment(d1);

        Employee e3=new Employee();
        e3.seteName("Vikas Kumar");
        e3.setAddress(a3);
        e3.setLaptop(l3);
        e3.setDepartment(d2);



        l1.setEmployee(e1);  //not setting employees for laptop will create a col with null values for FK
        l2.setEmployee(e2);  //we can also do l1->e2 but e2->l1, but it will be logically incorrect
        l3.setEmployee(e3);

        d1.getEmployees().add(e1);
        d1.getEmployees().add(e2);
        d2.getEmployees().add(e3);




        Transaction t1= session.beginTransaction();
        //session.persist(l1);
        //since cascading so even if we do not persist laptops still they will persisted automatically
        session.persist(e1);
        //session.persist(l2);
        session.persist(e2);
        session.persist(e3);
        session.persist(d1);
        session.persist(d2);

        t1.commit();

    }
}