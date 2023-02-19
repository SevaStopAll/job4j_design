package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;
import java.util.Calendar;
import java.util.function.Predicate;

public class FinancesReport implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final CurrencyConverter converter;
    private Currency convertFrom;
    private Currency convertTo;

    public FinancesReport(Store store, DateTimeParser<Calendar> dateTimeParser, CurrencyConverter converter, Currency convertFrom, Currency convertTo) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.converter = converter;
        this.convertFrom = convertFrom;
        this.convertTo = convertTo;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(converter.convert(convertFrom, employee.getSalary(), convertTo))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
