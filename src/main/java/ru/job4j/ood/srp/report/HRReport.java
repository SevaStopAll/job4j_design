package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.*;
import java.util.function.Predicate;

public class HRReport implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public HRReport(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        Comparator<Employee> comparator = Comparator.comparingDouble(Employee::getSalary).reversed();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        List<Employee> list = store.findBy(filter);
        list.sort(comparator);
        for (Employee employee : list) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
