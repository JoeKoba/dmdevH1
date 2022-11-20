package com.example.dmdevh1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runner {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory factory = configuration.buildSessionFactory();
             Session session = factory.openSession();
        ) {
            System.out.println("========================");
            System.out.println("ok");
            System.out.println("========================");
        }
    }
}
