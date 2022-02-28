package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportEngineIT implements Report {
    private Store store;

    public ReportEngineIT(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String ls = System.lineSeparator();
        StringBuilder text = new StringBuilder();
        text.append("<html>").append(ls)
                .append("<title>Report</title>").append(ls)
                .append("<body>").append(ls)
                .append(new ReportEngine(store).generate(filter))
                .append("/<body>").append(ls)
                .append("</html>");
        return text.toString();
    }
}
