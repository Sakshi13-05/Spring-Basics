package com.example.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.CourseRequest;
import com.example.practice.dto.CourseResponse;
import com.example.practice.service.CourseService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/vi/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity postMethodName(@Valid @RequestBody CourseRequest req) {
        // TODO: process POST request
        CourseResponse response = courseService.createCourse(req);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{Id}")
    public ResponseEntity getMethodName(@PathVariable Long Id) {
        CourseResponse response = courseService.getCourse(Id);
        return ResponseEntity.ok(response);
    }

}
