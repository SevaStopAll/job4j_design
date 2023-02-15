package ru.job4j.ood.srp;

import java.sql.Connection;

public interface Reader {

    Connection connect();

    String showName();

    String read();
}
