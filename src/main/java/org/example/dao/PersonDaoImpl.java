package org.example.dao;

import org.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements Dao<Person> {
    private SessionFactory sessionFactory;

    @Autowired
    public PersonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Person findById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        Person person = session.get(Person.class, id);
        transaction.commit();
        session.close();
        return person;
    }

    @Override
    public void save(Person person) {
       // Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }
}
