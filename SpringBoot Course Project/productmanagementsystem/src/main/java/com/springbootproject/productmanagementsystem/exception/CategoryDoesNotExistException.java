package com.springbootproject.productmanagementsystem.exception;

// exception thrown when non-existing category is
// tried to be accessed
public class CategoryDoesNotExistException extends RuntimeException {
    public CategoryDoesNotExistException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
