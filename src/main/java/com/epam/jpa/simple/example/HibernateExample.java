package com.epam.jpa.simple.example;

import com.epam.jpa.simple.factory.UserFactory;
import com.epam.jpa.simple.models.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateExample
{
    public static void main(String[] args)
    {
        final StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure() // configured settings from 'hibernate.cfg.xml'
                .build();
        final SessionFactory sessionFactory = new MetadataSources(serviceRegistry)
                .buildMetadata()
                .buildSessionFactory();

        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(UserFactory.getCustomer());
        session.save(UserFactory.getEmployee());
        session.getTransaction().commit();

        session.beginTransaction();
        readAllPersonsInheritable(session);
        //readAllPersons(session);
        session.getTransaction().commit();

        session.close();

        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }

    private static void readAllPersonsInheritable(final Session session)
    {
        session.createQuery("FROM Person p", Person.class).list()
                .forEach(person -> System.out.println("Person: " + person.getName()));
    }

    private static void readAllPersons(final Session session)
    {
        session.createQuery("FROM com.epam.jpa.simple.models.Person", Person.class).list()
                .forEach(person -> System.out.println("Person: " + person.getName()));
    }
}
