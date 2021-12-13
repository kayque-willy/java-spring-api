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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "student_table")
@EqualsAndHashCode
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    // --------- @ManyToOne - Mapeamento de muito para muitos ---------
    // O @JoinColumn é necessário para definir a chave estrangeira
    // O @JsonBackReference é necessario para evitar recursão do JSON em um
    // mapeamento bidirecional
    // o @EqualsAndHashCode.Exclude é necessário para remover o atributo do Equals e
    // HashCode gerados. Isso é necessário para evitar loop recursivo
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id_fk", nullable = true)
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Course course;

    // --------- @ElementCollection - Mapeamento de entidade fraca ---------
    // Mapeamento de uma entidade fraca com uso da notação @ElementCollection
    @ElementCollection
    @Column(name = "phone_number")
    private Set<String> phoneNumbers;
}
