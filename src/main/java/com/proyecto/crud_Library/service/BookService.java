package com.proyecto.crud_Library.service;

import com.proyecto.crud_Library.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
    Book findById(Long id);
    Book save(Book book);
    void deleteById(Long id);
    Book update(Long id, Book book);

}
