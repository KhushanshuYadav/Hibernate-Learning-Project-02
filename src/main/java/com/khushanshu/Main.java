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



        SessionFactory sf= new Configuration().configure().addAnnotatedClass(com.khushanshu.Employee.class).addAnnotatedClass(com.khushanshu.Laptop.class).buildSessionFactory();
        Session session=sf.openSession();

        Laptop l1=new Laptop();
        l1.setlBrand("Apple");

        Address a1=new Address();
        a1.setCity("Indore");
        a1.setPinCode("452010");
        a1.setState("M.P");
        Employee e1=new Employee();
        e1.seteName("Ram Singh");
        e1.setAddress(a1);
        e1.setLaptop(l1);



        Laptop l2=new Laptop();
        l2.setlBrand("HP");

        Address a2=new Address();
        a2.setCity("Kolkata");
        a2.setPinCode("210201");
        a2.setState("W.B.");
        Employee e2=new Employee();
        e2.seteName("Meera Singh");
        e2.setAddress(a2);
        e2.setLaptop(l2);


        l1.setEmployee(e1);  //not setting employees for laptop will create a col with null values for FK
        l2.setEmployee(e2);
        //we can also do l1->e2 but e2->l1 but it is logically incorrect

        Transaction t1= session.beginTransaction();
        session.persist(l1);
        session.persist(e1);
        session.persist(l2);
        session.persist(e2);
        t1.commit();

    }
}