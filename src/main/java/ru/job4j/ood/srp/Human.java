package ru.job4j.ood.srp;

public class Human implements Creature {

    public void breathe() {
        System.out.println("I breath Oxygen");
    }

    public void eat() {
        System.out.println("I eat meat and grass");
    }

    public void work() {
        System.out.println("I work 8 hours per day");
    }

    public void speak() {
        System.out.println("I speak using my roar and infra-sound");
    }
}
