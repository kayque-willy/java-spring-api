package com.api.crudspring.repository;

import com.api.crudspring.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// O @Repository permite extender as implementações do JPA com o spring, 
// abstraindo, assim, todos os métodos basicos do CRUD
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // É necessário declarar o findById aqui para que possa ser reconhecido pelo JPA
    public Course findById(long id);
}
