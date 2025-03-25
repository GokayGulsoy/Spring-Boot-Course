package com.week2lab.springframeworkexploration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Class {

    private final List<String> classes;

    public Class() {
        classes = new ArrayList<>();
        classes.add("Computer Science");
    }

    public String getClassName() {
        return classes.get(0);
    }

    @Override
    public String toString() {
        return "class";
    }

}
