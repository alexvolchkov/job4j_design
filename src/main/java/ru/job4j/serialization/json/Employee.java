package ru.job4j.serialization.json;

import ru.job4j.serialization.java.Contact;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    @XmlAttribute
    private String name;

    @XmlAttribute
    private boolean sex;

    @XmlElementWrapper(name = "children")
    @XmlElement(name = "child")
    private String[] children;

    private Contact contact;

    @XmlAttribute
    private double salary;

    @XmlAttribute
    private String department;

    public Employee() {
    }

    public Employee(String name, boolean sex, String[] children, Contact contact, double salary, String department) {
        this.name = name;
        this.sex = sex;
        this.children = children;
        this.contact = contact;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public boolean isSex() {
        return sex;
    }

    public String[] getChildren() {
        return children;
    }

    public Contact getContact() {
        return contact;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
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
