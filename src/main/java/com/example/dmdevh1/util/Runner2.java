package com.example.dmdevh1.util;

import com.example.dmdevh1.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Runner2 {

    public static void main(String[] args) {
        User user = User.builder()
                    .name("oleg")
                    .lastName("starec")
                    .build();

        try (SessionFactory factory = HibernateUtil.buildSessionFactory()) {
            try (Session session1 = factory.openSession()) {
                session1.beginTransaction();

                session1.saveOrUpdate(user);

                session1.getTransaction().commit();
            }
            try (Session session2 = factory.openSession()) {
                session2.beginTransaction();

                user.setAge((byte) 33);

                session2.getTransaction().commit();
            }
        }
    }
}
