package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonReport implements Report {

    final Gson gson;
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public JsonReport(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.gson = new GsonBuilder().create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var lib = new GsonBuilder().create();
        return lib.toJson(store);
    }
}
