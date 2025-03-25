package com.week2lab.springframeworkexploration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Book {

    private final List<String> books;

    public Book() {
        books = new ArrayList<>();
        books.add("Introduction to Spring Boot 3rd edition");
    }

    public String getBookName() {
        return books.get(0);
    }

    @Override
    public String toString() {
        return "book";
    }


}
