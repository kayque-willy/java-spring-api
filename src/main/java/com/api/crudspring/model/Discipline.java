package com.api.crudspring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "discipline_table")
public class Discipline implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    // Mapeamento de muito para muitos
    // O @JoinTable é necessário para definir a tabela de junção e evitar que sejam
    // criadas mais de uma tabela
    @ManyToMany()
    @JoinTable(name = "course_discipline", joinColumns = @JoinColumn(name = "discipline_id_fk"), inverseJoinColumns = @JoinColumn(name = "course_id_fk"))
    private Set<Course> courseList;

}
