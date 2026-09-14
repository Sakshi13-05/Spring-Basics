package com.example.practice.dto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

public record CourseRequest(
        @Id Long courseId,

        @NotBlank(message = "Enter a course name") String courseName,

        String prof,

        @NotNull(message = "Enter a suiatble price") BigDecimal price,

        @NotNull(message = "Allocate proper duration") Double duration) {
}