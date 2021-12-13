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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//O @Getter e o @Setter geram os gets e sets da classe automaticamente
//O @Setter, @Getter e @NoArgsConstructor gera automaticamente os gets, sets, construtor
//O @Entity indica que a classe vai ser mapeada para ser persistida no banco de dados
//O @Table define o nome da tabela no banco de dados
@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "course_table")
public class Course implements Serializable {
    // --------- Identificador ---------
    // As anotações @Id e @GeneratedValue indicam a chave primária e a estratégia do
    // auto incremento
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // --------- Atributos ---------
    // A anotação @Column define os atributos a serem definidos no banco de dados
    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "category", length = 200, nullable = false)
    private String category;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

    // --------- @OneToMany - Mapeamento de um para muitos ---------
    // O @JoinColumn é necessário para que não seja criada uma tabela mappedBy
    // indica o nome do objeto referenciado
    // O @JsonManagedReference é necessario para evitar recursão do JSON em um
    // mapeamento @OneToMany e @ManyToOne
    // o @EqualsAndHashCode.Exclude é necessário para remover o atributo do Equals e
    // HashCode gerados. Isso é necessário para evitar loop recursivo
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private Set<Student> studentList;

    // --------- @ManyToMany - Mapeamento de muito para muitos ---------
    // O @JoinTable é necessário para definir a tabela de junção e evitar que sejam
    // criadas mais de uma tabela
    // O @ManyToMany não precisa do @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "course_discipline", joinColumns = @JoinColumn(name = "course_id_fk"), inverseJoinColumns = @JoinColumn(name = "discipline_id_fk"))
    @EqualsAndHashCode.Exclude
    private Set<Discipline> disciplineList;

}
