package ru.job4j.io.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement
@XmlAccessorType
public class Person {
    @XmlAttribute
    private boolean sex;
    @XmlAttribute
    private int age;
    @XmlElement
    private Contact contact;
    @XmlElement
    private String[] statuses;

    public Person() { }

    public Person(boolean sex, int age, Contact contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }
}

