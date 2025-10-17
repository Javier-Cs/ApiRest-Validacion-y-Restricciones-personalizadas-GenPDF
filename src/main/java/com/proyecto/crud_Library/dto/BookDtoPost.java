package com.proyecto.crud_Library.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record BookDtoPost(

        String code,

        @NotBlank(message = "El titulo no puede ser vacio o nulo")
        String titulo,

        @NotBlank(message = "El autor no puede ser vacio o nulo")
        String autor,

        @NotBlank(message = "El nombre de editorial no puede ser vacio o nulo")
        String editorial,

        @NotNull
        LocalDateTime fechaPublicacion,

        @NotNull()
        Integer numPage,

        String genero,

        Boolean estado

) {


}
