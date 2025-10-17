package com.proyecto.crud_Library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record BookDtoGet (

        String titulo,

        String autor,

        String editorial,

        LocalDateTime fechaPublicacion,

        Integer numPage,

        String genero
){
}
