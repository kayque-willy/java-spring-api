package com.api.crudspring.controller;

import java.util.List;

import com.api.crudspring.model.Course;
import com.api.crudspring.repository.CourseRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

// O @RestController indica que essa classe é um endpoint que vai retornar requisições REST
// A injeção da independencia do repositório esta feita no construtor, que é
// gerado com a anotação @AllArgsConstructor
// O @RequestMapping indica a URL do controller
@RestController
@AllArgsConstructor
@RequestMapping("/api/cursos")
public class CursoController {

    private final CourseRepository courseRepository;

    // As anotações de mapping indicam o endereço para chamada do método
    @GetMapping("/list")
    public List<Course> listCourse() {
        return this.courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course findCourseById(@PathVariable (value = "id") long id) {
        return this.courseRepository.findById(id);
    }

    @PostMapping("/save")
    public Course saveCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @PutMapping("/save")
    public Course updateCourse(@RequestBody Course course){
         return courseRepository.save(course);
    }

    @DeleteMapping("/delete")
    public void deleteCourse(@RequestBody Course course){
         courseRepository.delete(course);
    }

}
