package com.epam.jpa.simple.models;

import javax.persistence.Entity;

@Entity
public class Employee extends Person
{
    private String position;

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }
}
