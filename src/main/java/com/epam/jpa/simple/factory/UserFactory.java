package com.epam.jpa.simple.factory;

import com.epam.jpa.simple.models.*;

import java.util.Arrays;
import java.util.Calendar;

public class UserFactory {

    private static final Address address = new Address();

    static {
        address.setStreet("Baker Street");
        address.setBuilding("221B");
    }

    public static Customer getCustomer() {
        final Customer customer = new Customer();
        customer.setName("Jon Snow");
        customer.setTitle(Title.MR);
        final Calendar calendar = Calendar.getInstance();
        calendar.set(1999, Calendar.FEBRUARY, 23, 1, 2, 3);
        customer.setDateOfBirth(calendar.getTime());
        customer.setBalance(100.0);
        customer.setAddress(getAddress());
        return customer;
    }

    public static Employee getEmployee() {
        final Employee employee = new Employee();
        employee.setName("Daenerys Targaryen");
        employee.setTitle(Title.MS);
        final Calendar calendar = Calendar.getInstance();
        calendar.set(2003, Calendar.MARCH, 8, 1, 2, 3);
        employee.setDateOfBirth(calendar.getTime());
        employee.setPosition("Mother of Dragons");
        employee.setAddress(getAddress());
        employee.setPhones(Arrays.asList("+375 (29) 123-45-67", "8-800-555-35-35"));
        return employee;
    }

    private static Address getAddress() {
        return address;
    }
}
