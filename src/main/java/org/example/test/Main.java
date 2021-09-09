package org.example.test;

import org.example.WebConfiguration;
import org.example.entity.number.ComplexNumber;
import org.example.entity.number.SimpleNumber;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(WebConfiguration.class);
//        SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
//
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
////        session.save(new ComplexNumber());
////        session.save(new SimpleNumber());
//        session.getTransaction().commit();
//        session.close();
        System.out.println(2/0);
    }
}
