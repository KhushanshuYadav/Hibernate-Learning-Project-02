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
        l1.setlBrand("Dell");

        Address a1=new Address();
        a1.setCity("Bhopal");
        a1.setPinCode("452011");
        a1.setState("M.P");
        Employee e1=new Employee();
        e1.seteName("Shyam Singh");
        e1.setAddress(a1);

        Transaction t1= session.beginTransaction();
        session.merge(l1);
        session.persist(e1);
        t1.commit();

    }
}