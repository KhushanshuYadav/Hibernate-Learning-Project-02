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



        SessionFactory sf= new Configuration().configure().addAnnotatedClass(com.khushanshu.Employee.class).buildSessionFactory();
        Session session=sf.openSession();

        Address a1=new Address();
        a1.setCity("Indore");
        a1.setPinCode("452010");
        a1.setState("M.P");
        Employee e1=new Employee();
        e1.seteName("Ram Singh");
        e1.setAddress(a1);

        Transaction t1= session.beginTransaction();
        session.persist(e1);
        t1.commit();

    }
}