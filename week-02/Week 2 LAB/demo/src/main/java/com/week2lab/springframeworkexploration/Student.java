package com.week2lab.springframeworkexploration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private String name;

    @Autowired
    private Grade grade; // injected via field

    private Class studentClass; // injected via constructor

    private Book book; // injected via setter

    public Student(@Autowired Class studentClass) {
        name = "Adam";
        this.studentClass = studentClass;
    }

    @Autowired
    public void setBook(Book book) {
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade.getLetterGrade();
    }

    public String getClassName() {
        return studentClass.getClassName();
    }

    public String getBookName() {
        return book.getBookName();
    }

    @Override 
    public String toString() {
        return "Student with properties: Name: " + getName() + " Grade: " + getGrade() + " Class: " + getClassName();
    }

}
