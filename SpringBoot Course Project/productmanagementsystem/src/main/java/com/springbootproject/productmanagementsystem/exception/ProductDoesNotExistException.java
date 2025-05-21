package com.springbootproject.productmanagementsystem.exception;

// exception thrown when non-existing product is
// tried to be accessed
public class ProductDoesNotExistException extends RuntimeException {
    public ProductDoesNotExistException(String exceptionMessage) {
        super(exceptionMessage);
    }

}
