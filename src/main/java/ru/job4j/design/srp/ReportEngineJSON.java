package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class ReportEngineJSON implements Report {
    private Store store;

    public ReportEngineJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson gson = new GsonBuilder().create();
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            text.append(gson.toJson(employee))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
