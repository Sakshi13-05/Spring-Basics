package com.example.practice.service;

import org.springframework.stereotype.Service;

import com.example.practice.dto.CourseRequest;
import com.example.practice.dto.CourseResponse;
import com.example.practice.entity.Course;
import com.example.practice.exception.CourseNotFound;
import com.example.practice.repository.CourseRepository;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseResponse createCourse(CourseRequest courseRequest) {
        Course course = new Course(
                courseRequest.prof(),
                courseRequest.courseName(),
                courseRequest.price(),
                courseRequest.duration());

        Course savedCourse = courseRepository.save(course);

        return mapToResponse(savedCourse);
    }

    public CourseResponse getCourse(Long Id) {
        Course course = courseRepository.findById(Id)
                .orElseThrow(() -> new CourseNotFound("Course not there with the given id " + Id));

        return mapToResponse(course);
    }

    private CourseResponse mapToResponse(Course course) {
        return new CourseResponse(

                course.getCourseName(),
                course.getProf(),
                course.getPrice(),
                course.getDuration());

    }
}
