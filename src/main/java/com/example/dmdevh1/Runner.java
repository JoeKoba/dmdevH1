package com.example.dmdevh1;

import com.example.dmdevh1.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runner {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class).configure();

        try (SessionFactory factory = configuration.buildSessionFactory();
             Session session = factory.openSession()) {
            session.beginTransaction();

            User user = User.builder()
                    .name("Joe")
                    .lastName("Cocker")
                    .age((byte) 20)
                    .build();
            session.save(user);

            session.getTransaction().commit();
        }
    }
}
