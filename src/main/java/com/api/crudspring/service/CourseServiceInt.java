package com.api.crudspring.service;

import java.util.List;

import com.api.crudspring.model.Course;

public interface CourseServiceInt {

    public List<Course> findAllCourses();
    public Course findCourseById(long id);
    public Course saveCourse(Course course);
    public Course updateCourse(Course course);
    public void deleteCourse(Course course);
    
}
