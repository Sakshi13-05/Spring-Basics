package com.example.practice.exception;

public class CourseNotFound extends RuntimeException {
    public CourseNotFound(String message) {
        super(message);
    }

}
