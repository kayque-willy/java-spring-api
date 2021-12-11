package com.api.crudspring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "student_table")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    // Mapeamento de um para muitos
    // O @JoinColumn é necessário para que não seja criada uma tabela
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id_fk", updatable = false, nullable = true)
    private Course course;

    @ElementCollection
    @Column(name = "phone_number")
    private Set<String> phoneNumbers;
}
