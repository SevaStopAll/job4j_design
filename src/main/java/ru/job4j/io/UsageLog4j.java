package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int numbers = 123456789;
        double weight = 88.7;
        long iq = 10_000_000_000L;
        boolean isLearning = true;
        byte age = 125;
        short colours = 256;
        float anything = 10.25f;
        char question = '?';
        LOG.debug("Just info numbers : {}, weight : {}, iq : {}, isLearning : {}, age : {}, colours : {}, anything : {}, question : {}", numbers, weight, iq, isLearning, age, colours, anything, question);
    }
}