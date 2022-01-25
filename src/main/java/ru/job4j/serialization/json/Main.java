package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.serialization.java.Contact;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println("_________________________");
        jaxb();
        System.out.println("_________________________");
        jsonObject();
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

    public static void jsonObject() {
        Contact contact = new Contact(123456, "123-456-22");
        JSONObject jsonContact = new JSONObject();
        jsonContact.put("zipCode", contact.getZipCode());
        jsonContact.put("phone", contact.getPhone());
        List<String> children = new ArrayList<>();
        children.add("Alex");
        children.add("Ivan");
        JSONArray jsonChildren = new JSONArray(children);
        final Employee employee = new Employee(
                "Olga", false, new String[]{"Maria"},
                new Contact(11111, "111-111-11"),
                100, "IT");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", employee.getName());
        jsonObject.put("sex", employee.isSex());
        jsonObject.put("children", jsonChildren);
        jsonObject.put("contact", jsonContact);
        jsonObject.put("salary", employee.getSalary());
        jsonObject.put("department", employee.getDepartment());
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(employee).toString());
    }
}
