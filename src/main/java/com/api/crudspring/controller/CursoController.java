package com.api.crudspring.controller;

import java.util.List;

import com.api.crudspring.model.Course;
import com.api.crudspring.repository.CourseRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cursos")
public class CursoController {

    private final CourseRepository courseRepository;

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Course> list(){
        return this.courseRepository.findAll();
    }
}
