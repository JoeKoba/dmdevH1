package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runner {

    public static void main(String[] args) {
        Company company = Company.builder()
                .name("Google").build();

        UserTest user = UserTest.builder()
                .name("Wesley")
                .lastName("Adams")
                .company_id(company)
                .build();

        try (SessionFactory factory = new Configuration()
                .configure().addAnnotatedClass(UserTest.class).buildSessionFactory()){
            try (Session session = factory.openSession();) {
                session.beginTransaction();

                session.save(company);
                session.save(user);

                session.getTransaction().commit();
            }
        }

    }
}
