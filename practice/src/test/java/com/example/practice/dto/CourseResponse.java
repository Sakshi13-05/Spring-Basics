package com.example.practice.dto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

public record CourseResponse(
        @NotBlank(message = "Course name cant be empty") String course_name,

        String prof,

        @NotNull(message = "Fees cannot be blank") BigDecimal price,

        @NotNull(message = "Duration cant be empty") Double duration) {
}
