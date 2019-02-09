package com.epam.jpa.simple.example;

import com.epam.jpa.simple.factory.UserFactory;
import com.epam.jpa.simple.models.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaExample
{
    private static final String PERSISTENCE_UNIT = "my-persistence-unit";

    public static void main(String[] args)
    {
        final EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory(PERSISTENCE_UNIT);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(UserFactory.getCustomer());
        entityManager.persist(UserFactory.getEmployee());
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        readAllPersonsInheritable(entityManager);
//        readAllPersons(entityManager);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void readAllPersonsInheritable(final EntityManager entityManager)
    {
        entityManager.createQuery("FROM Person p", Person.class).getResultList()
                .forEach(person -> System.out.println("Person: " + person.getName()));
    }

    private static void readAllPersons(final EntityManager entityManager)
    {
        final List resultList = entityManager.createQuery("FROM Customer c, Employee e").getResultList();
        for (final Object array : resultList)
        {
            if (array instanceof Object[])
            {
                for (final Object element : ((Object[]) array))
                {
                    if (element instanceof Person)
                    {
                        System.out.println("Person: " + ((Person) element).getName());
                    }
                }
            }
        }
    }
}
