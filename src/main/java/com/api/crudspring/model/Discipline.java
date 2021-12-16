package com.api.crudspring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "discipline_table")
public class Discipline implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    // --------- @ManyToMany - Mapeamento de muito para muitos ---------
    // O @JoinTable é necessário para definir a tabela de junção e evitar que sejam
    // criadas mais de uma tabela
    // O @JsonBackReference é necessario para evitar recursão do JSON em um
    // mapeamento bidirecional
    // o @EqualsAndHashCode.Exclude é necessário para remover o atributo do Equals e
    // HashCode gerados. Isso é necessário para evitar loop recursivo
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "course_discipline", joinColumns = @JoinColumn(name = "discipline_id_fk"), inverseJoinColumns = @JoinColumn(name = "course_id_fk"))
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Set<Course> courseList;

    // --------- @OneToOne - Mapeamento de um para um ---------
    // O @JoinColumn é colocado na entidade onde a relação vai ser referenciada
    // O @JsonBackReference é necessario para evitar recursão do JSON em um
    // mapeamento bidirecional
    // O @EqualsAndHashCode.Exclude é necessário para remover o atributo do Equals e
    // HashCode gerados. Isso é necessário para evitar loop recursivo
    @OneToOne
    @JoinColumn(name = "teacher_id", nullable = true)
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private Teacher teacher;

}
