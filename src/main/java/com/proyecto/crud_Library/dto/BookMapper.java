package com.proyecto.crud_Library.dto;


import com.proyecto.crud_Library.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {

    // mapeamos una entidad a un DTO
    BookDtoGet BooktoDtoGet(Book book);

    // mapeamos un DTO a una entidad
    Book dtoGetToBook(BookDtoGet bookDto);


    // mapeamos una entidad a un DTO
    BookDtoPost BooktoDtoPost(Book book);

    // mapeamos un DTO a una entidad
    Book dtoPostToBook(BookDtoPost bookDto);


    // metodo para actualizar
    @Mapping(target = "id", ignore = true)
     void updtBookToDTO(BookDtoPost bookUpdt, @MappingTarget Book book);


}
