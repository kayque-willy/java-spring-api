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
// A injeção da independencia do repositório esta feita no construtor, que é
// gerado com a anotação @AllArgsConstructor
@AllArgsConstructor
// O @RequestMapping indica a URL do controller
@RequestMapping("/api/cursos")
public class CursoController {

    private final CourseRepository courseRepository;

    // @RequestMapping(method = RequestMethod.GET)
    // O @GetMapping indica o endereço para chamada do método
    @GetMapping("/list")
    public List<Course> list() {
        return this.courseRepository.findAll();
    }
}
