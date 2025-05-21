package com.springbootproject.productmanagementsystem.exception;

// exception thrown when category to be crated already exists
public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException(String exceptionMessage) {
        super(exceptionMessage);
    }

}
