package com.api.crudspring.controller;

import java.util.List;

import com.api.crudspring.model.Course;
import com.api.crudspring.repository.CourseRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

// O @RestController indica que essa classe é um endpoint que vai retornar requisições REST
@RestController
@AllArgsConstructor
@RequestMapping("/api/cursos")
public class CursoController {

    // A injeção da independencia do repositório esta feita no construtor com a
    // anotação @AllArgsConstructor
    private final CourseRepository courseRepository;

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/list")
    public List<Course> list() {
        return this.courseRepository.findAll();
    }
}
