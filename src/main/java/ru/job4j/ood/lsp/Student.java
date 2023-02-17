package ru.job4j.ood.lsp;

import java.sql.SQLOutput;

public class Student {
    protected double midMark;

    public void passExam() {
        if (midMark > 2.5) {
            System.out.println("You did it");
        }
        if (midMark > 4.5) {
            System.out.println("And you did it excellent!");
        }
    }
}

class CollegeStudent extends Student {

    @Override
    public void passExam() {
        if (midMark > 2.5) {
            System.out.println("You did it");
        }
    }

}
