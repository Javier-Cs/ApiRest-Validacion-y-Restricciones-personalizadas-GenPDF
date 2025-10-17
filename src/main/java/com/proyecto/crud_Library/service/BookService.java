package com.proyecto.crud_Library.service;

import com.proyecto.crud_Library.dto.BookDtoGet;
import com.proyecto.crud_Library.dto.BookDtoPost;
import com.proyecto.crud_Library.entity.Book;

import java.util.List;

public interface BookService {

    List<BookDtoGet> findAll();
    BookDtoGet findById(Long id);
    BookDtoPost save(BookDtoPost book);
    void deleteById(Long id);
    BookDtoPost update(Long id, BookDtoPost book);
}
