package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;

import java.util.function.Predicate;

public class JsonReport implements Report{
    @Override
    public String generate(Predicate<Employee> filter) {
        return null;
    }
}
