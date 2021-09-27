package org.example.util;

import hibernate.oneToOne.bi.entities.Passport;
import hibernate.oneToOne.bi.entities.Person;
import org.example.entity.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public SessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Person.class);
                sessionFactory = configuration
                        .buildSessionFactory(new StandardServiceRegistryBuilder()
                        .build());
            } catch (Exception ex) {
                throw new RuntimeException("There is issue in hibernate hibernate.oneToOne.uni.util");
            }
        }
        return sessionFactory;
    }
}
