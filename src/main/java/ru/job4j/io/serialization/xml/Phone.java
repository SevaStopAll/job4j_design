package ru.job4j.io.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class Phone {
    @XmlAttribute
    boolean isApple;
    @XmlAttribute
    int weight;
    @XmlAttribute
    String model;
    @XmlElement
    CPU cpu;
    @XmlElement
    int[] bands;

    public Phone() {

    }

    public Phone(boolean isApple, int weight, String model, CPU cpu, int[] bands) {
        this.isApple = isApple;
        this.weight = weight;
        this.model = model;
        this.cpu = cpu;
        this.bands = bands;
    }

    @Override
    public String toString() {
        return "Phone{"
                + "isApple=" + isApple
                + ", weight=" + weight
                + ", model='" + model + '\''
                + ", cpu=" + cpu
                + ", bands=" + Arrays.toString(bands)
                + '}';
    }
}
