package com.api.crudspring.controller;

import java.util.List;

import com.api.crudspring.model.Course;
import com.api.crudspring.service.CourseService;

import org.apache.catalina.connector.Response;
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
@RequestMapping("/api")
public class CursoController {

    private final CourseService courseService;

    // As anotações de mapping indicam o endereço para chamada do método
    @GetMapping("")
    public String index() {
        return "<h1>Exemplo de API REST - Java Spring</h1>Java Spring, JPA Hibernate e PostgreSQL<span></span>";
    }

    // Salvar curso
    @PostMapping("cursos")
    public Course saveCourse(@RequestBody Course course) {
        return this.courseService.saveCourse(course);
    }

    // Listar cursos
    @GetMapping("cursos")
    public List<Course> listCourse() {
        return this.courseService.findAllCourses();
    }

    // Atualizar curso
    @PutMapping("cursos/{id}")
    public Course updateCourse(@PathVariable(value = "id") long id, @RequestBody Course course) {
        if (id != course.getId()) {
            return null;
        }
        return this.courseService.saveCourse(course);
    }

    // Recuperar curso por id
    @GetMapping("cursos/{id}")
    public Course findCourseById(@PathVariable(value = "id") long id) {
        return this.courseService.findCourseById(id);
    }

    // Remover curso
    @DeleteMapping("cursos/{id}")
    public void deleteCourse(@PathVariable(value = "id") long id, @RequestBody Course course) {
        if (id != course.getId()) {
            return;
        }
        this.courseService.deleteCourse(course);
    }

}
