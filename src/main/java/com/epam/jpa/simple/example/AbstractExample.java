package com.epam.jpa.simple.example;

import com.epam.jpa.simple.models.Person;

public abstract class AbstractExample {

    protected static void printPersonInfo(final Person person) {
        System.out.printf("Person: %s, %s%n", person.getName(), person.getTitle());
    }
}
