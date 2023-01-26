package ru.job4j.io.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cpu")
public class CPU {
    @XmlAttribute
    String name;

    public CPU() {

    }
    public CPU(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "cpu{" + "name='" + name + '\'' + '}';
    }
}

