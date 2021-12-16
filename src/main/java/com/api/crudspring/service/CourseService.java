package com.api.crudspring.service;

import java.util.List;

import com.api.crudspring.repository.CourseRepository;
import com.api.crudspring.model.Course;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

// O @Service e o @Repositório prcixam implementar intefaces
@Service
@AllArgsConstructor
public class CourseService implements CourseServiceInt {

    // A injeção de dependencia é feita com o @AllArgsConstructor
    private final CourseRepository courseRepository;

    @Override
    public List<Course> findAllCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course findCourseById(long id) {
        return this.courseRepository.findById(id);
    }

    @Override
    public Course saveCourse(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Course course) {
        this.courseRepository.delete(course);
    }
}
