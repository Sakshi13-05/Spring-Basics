package com.example.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practice.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Spring Data generates findAll(), findById(), save(), delete() automatically!
}
