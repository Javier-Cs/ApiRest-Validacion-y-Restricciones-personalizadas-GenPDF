package com.proyecto.crud_Library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
// uso de table para la configuracion de persistencia de la tabla en la base de datos
@Table(name = "book_tbl", schema = "library")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Column(name = "bookId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "editorial")
    private String editorial;

    @Column(name = "datePublication")
    private LocalDate fechaPublicacion;

    @Column(name = "dateAddBiblioteca")
    private LocalDate fechaAggBiblioteca;

    @Column(name = "numPage")
    private int numPage;

    @Column(name = "state")
    private boolean estado;

    @Column(name = "gen")
    private String genero;

//    @Lob
//    private byte[] imagen;

}
