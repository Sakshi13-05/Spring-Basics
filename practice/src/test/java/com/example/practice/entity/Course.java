package com.example.practice.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String prof;

    @Column(nullable = false)
    private BigDecimal price;

    private Double duration;

    public Course(String prof, String courseName, BigDecimal price, Double duration) {
        this.courseName = courseName;
        this.prof = prof;
        this.price = price;
        this.duration = duration;

    }
}