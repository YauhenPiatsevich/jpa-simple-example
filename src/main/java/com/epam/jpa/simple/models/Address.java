package com.epam.jpa.simple.models;

import javax.persistence.*;

//@Embeddable // if we don't want to create a new table in DB and we are fine with duplicate data
@Entity
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;

    private String building;

//    @OneToOne(mappedBy = "address")
//    private Person person;

    public long getId()
    {
        return id;
    }

    public void setId(final long id)
    {
        this.id = id;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(final String street)
    {
        this.street = street;
    }

    public String getBuilding()
    {
        return building;
    }

    public void setBuilding(final String building)
    {
        this.building = building;
    }

//    public Person getPerson()
//    {
//        return person;
//    }

//    public void setPerson(final Person person)
//    {
//        this.person = person;
//    }
}
