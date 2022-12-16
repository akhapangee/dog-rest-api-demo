package com.akhilesh.dogrestapidemo.service;

public class DogNotFoundException extends RuntimeException {
    public DogNotFoundException() {
    }

    public DogNotFoundException(String message) {
        super(message);
    }
}
