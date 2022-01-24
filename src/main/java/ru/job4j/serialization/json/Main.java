package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.serialization.java.Contact;

public class Main {
    public static void main(String[] args) {
        final Employee employee = new Employee("Alex", true, new String[] {"Sergey", "Oleg"},
                new Contact(123456, "+7 123 456-78-90"),
                100.5, "Administration");
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(employee));
        final String employeeJson =
                "{"
                        + "\"name\":\"Ivan\","
                        + "\"sex\":true,"
                        + "\"children\":"
                        + "[\"Olga\"],"
                        + "\"contact\":"
                        + "{"
                        + "\"zipCode\":111111,"
                        + "\"phone\":\"+7 222 222-22-22\""
                        + "},"
                        + "\"salary\":222,"
                        + "\"department\":\"Administration\""
                        + "}";
        final Employee employeeMod = gson.fromJson(employeeJson, Employee.class);
        System.out.println(employeeMod);
    }
}
