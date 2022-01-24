package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.serialization.java.Contact;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
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
        jaxb();
    }

    public static void jaxb() throws JAXBException, IOException {
        Employee employee = new Employee("Alex", true, new String[] {"Sergey", "Oleg"},
                new Contact(123456, "+7 123 456-78-90"),
                100.5, "Administration");
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(employee, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        }
    }
}
