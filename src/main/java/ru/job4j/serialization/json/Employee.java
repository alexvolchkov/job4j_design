package ru.job4j.serialization.json;

import ru.job4j.serialization.java.Contact;

import java.util.Arrays;

public class Employee {
    private String name;
    private boolean sex;
    private String[] children;
    private Contact contact;
    private double salary;
    private String department;

    public Employee(String name, boolean sex, String[] children, Contact contact, double salary, String department) {
        this.name = name;
        this.sex = sex;
        this.children = children;
        this.contact = contact;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "name='" + name + '\''
                + ", sex=" + sex
                + ", children=" + Arrays.toString(children)
                + ", contact=" + contact
                + ", salary=" + salary
                + ", department='" + department + '\''
                + '}';
    }
}
