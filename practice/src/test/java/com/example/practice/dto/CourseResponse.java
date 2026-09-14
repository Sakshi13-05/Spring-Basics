package com.example.practice.dto;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

public class CourseResponse {

    @NotBlank
    String course_name;

    String prof;

    @NotBlank
    double duration;
}
