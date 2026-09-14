package com.example.practice.dto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

public class CourseRequest {
    @Id
    Long courseId;

    @NotBlank
    String courseName;

    String prof;

    @NotBlank
    BigDecimal price;

    @NotBlank
    BigDecimal duration;
}