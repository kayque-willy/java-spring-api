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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "discipline_table")
public class Discipline implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    // --------- Mapeamento de muito para muitos ---------
    // O @JoinTable é necessário para definir a tabela de junção e evitar que sejam
    // criadas mais de uma tabela
    // O @JsonBackReference é necessario para evitar recursão do JSON em um mapeamento bidirecional
    @ManyToMany()
    @JoinTable(name = "course_discipline", joinColumns = @JoinColumn(name = "discipline_id_fk"), inverseJoinColumns = @JoinColumn(name = "course_id_fk"))
    @JsonBackReference
    private Set<Course> courseList;

}
