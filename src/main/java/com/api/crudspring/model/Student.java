package com.api.crudspring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "student_table")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    // --------- Mapeamento de muito para muitos ---------
    // O @JoinColumn é necessário para que não seja criada uma tabela
    // O @JsonBackReference é necessario para evitar recursão do JSON em um mapeamento bidirecional
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id_fk", nullable = true)
    @JsonBackReference
    private Course course;

    // --------- Mapeamento de entidade fraca ---------
    // Mapeamento de uma entidade fraca com uso da notação @ElementCollection
    @ElementCollection
    @Column(name = "phone_number")
    private Set<String> phoneNumbers;
}
