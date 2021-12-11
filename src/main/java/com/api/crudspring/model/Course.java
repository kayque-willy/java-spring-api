package com.api.crudspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

//O @Getter e o @Setter geram os gets e sets da classe automaticamente
//O @Data gera automaticamente os gets, sets, construtor, equals e toString
//O @Entity indica que a classe vai ser mapeada para ser persistida no banco de dados
@Data
@Entity
public class Course {
    // As anotações  @Id e @GeneratedValue indicam a chave primária e o auto incremento
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // A anotação @Column define os atributos a serem definidos no banco de dados
    @Column(name = "name", length = 200, nullable = false)
    private String name;
    
    @Column(name = "category", length = 200, nullable = false)
    private String category;
}
