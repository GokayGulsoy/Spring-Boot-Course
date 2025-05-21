package com.springbootproject.productmanagementsystem.exception;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(String exceptionMessage) {
        super(exceptionMessage);
    }

}
