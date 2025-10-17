package com.proyecto.crud_Library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
// uso de table para la configuracion de persistencia de la tabla en la base de datos
@Table(name = "book_tbl", schema = "libreria")
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
    private LocalDateTime fechaPublicacion;

    @Column(name = "dateAddBiblioteca")
    private LocalDateTime fechaAggBiblioteca = LocalDateTime.now();

    @Column(name = "numPage")
    private int numPage;


    @Column(name = "state")
    private boolean estado = true;


    @Column(name = "genero")
    private String genero;

//    @Lob
//    private byte[] imagen;

}
