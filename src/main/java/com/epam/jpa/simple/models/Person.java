package com.epam.jpa.simple.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//@MappedSuperclass // if we are not care about inheritance and a common ancestor in DB
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//public abstract class Person
public class Person
{
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private String name;

    private Title title;

    private Date dateOfBirth;

    //@Embedded // if we don't want to create a new table in DB and we are fine with duplicate data
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ElementCollection
    private List<String> phones;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Title getTitle()
    {
        return title;
    }

    public void setTitle(Title title)
    {
        this.title = title;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(final Address address)
    {
        this.address = address;
    }

    public List<String> getPhones()
    {
        return phones;
    }

    public void setPhones(final List<String> phones)
    {
        this.phones = phones;
    }
}
