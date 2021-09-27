package org.example.util;

import org.example.entity.Job;
import org.example.entity.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class ApplicationConfig {

    @Bean
    public Person person() {
        Person person = new Person();
        return person;
    }

    @Bean
    public Job job() {
        Job job = new Job();
        return job;
    }

    @Bean
    public SessionFactory sessionFactory() {
        SessionFactory sessionFactory;
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Job.class);
        sessionFactory = configuration
                .buildSessionFactory(new StandardServiceRegistryBuilder()
                        .build());

        return sessionFactory;
    }
}
