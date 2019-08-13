package com.epam.jpa.simple.example;

import com.epam.jpa.simple.factory.UserFactory;
import com.epam.jpa.simple.models.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaExample extends AbstractExample {

    private static final String PERSISTENCE_UNIT = "my-persistence-unit";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory(PERSISTENCE_UNIT);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.persist(UserFactory.getCustomer());
        entityManager.persist(UserFactory.getEmployee());
        entityTransaction.commit();

        entityTransaction.begin();
        readAllPersonsInheritable(entityManager);
        //readAllPersonsInheritableWithHibernate(entityManager);
        //readAllPersons(entityManager);
        entityTransaction.commit();
        entityManager.close();
    }

    private static void readAllPersonsInheritable(final EntityManager entityManager) {
        entityManager.createQuery("FROM Person p", Person.class).getResultList()
                .forEach(JpaExample::printPersonInfo);
    }

    private static void readAllPersonsInheritableWithHibernate(final EntityManager entityManager) {
        entityManager.createQuery("FROM com.epam.jpa.simple.models.Person", Person.class).getResultList()
                .forEach(JpaExample::printPersonInfo);
    }

    private static void readAllPersons(final EntityManager entityManager) {
        final List resultList = entityManager.createQuery("FROM Customer c, Employee e").getResultList();
        for (final Object array : resultList) {
            if (array instanceof Object[]) {
                for (final Object element : ((Object[]) array)) {
                    if (element instanceof Person) {
                        final Person person = (Person) element;
                        printPersonInfo(person);
                    }
                }
            }
        }
    }
}
