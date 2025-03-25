package com.week2lab.springframeworkexploration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Grade {

    private final List<String> grades;

    public Grade() {
        grades = new ArrayList<>();
        grades.add("BB");
    }

    public String getLetterGrade() {
        return grades.get(0);
    }

    @Override
    public String toString() {
        return "grade";
    }

}
