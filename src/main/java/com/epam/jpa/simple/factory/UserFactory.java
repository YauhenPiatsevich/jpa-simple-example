package com.epam.jpa.simple.factory;

import com.epam.jpa.simple.models.Customer;
import com.epam.jpa.simple.models.Employee;
import com.epam.jpa.simple.models.Title;

import java.util.Calendar;

public class UserFactory
{

    public static Customer getCustomer()
    {
        final Customer customer = new Customer();
        customer.setName("Jon Snow");
        customer.setTitle(Title.MR);
        final Calendar calendar = Calendar.getInstance();
        calendar.set(1999, Calendar.FEBRUARY, 23, 1, 2, 3);
        customer.setDateOfBirth(calendar.getTime());
        customer.setBalance(100.0);
        return customer;
    }

    public static Employee getEmployee()
    {
        final Employee employee = new Employee();
        employee.setName("Daenerys Targaryen");
        employee.setTitle(Title.MS);
        final Calendar calendar = Calendar.getInstance();
        calendar.set(2003, Calendar.MARCH, 8, 1, 2, 3);
        employee.setDateOfBirth(calendar.getTime());
        employee.setPosition("Mother of Dragons");
        return employee;
    }
}
