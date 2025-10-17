package com.proyecto.crud_Library.service;

import com.proyecto.crud_Library.entity.Book;
import com.proyecto.crud_Library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book update(Long id , Book book) {
        Book updatedBook = bookRepository.findById(id).orElse(null);

        assert updatedBook != null;
        updatedBook.setTitulo(book.getTitulo());
        updatedBook.setCode(book.getCode());
        updatedBook.setAutor(book.getAutor());
        updatedBook.setEditorial(book.getEditorial());
        updatedBook.setFechaPublicacion(book.getFechaPublicacion());
        updatedBook.setFechaAggBiblioteca(book.getFechaAggBiblioteca());
        updatedBook.setNumPage(book.getNumPage());
        updatedBook.setEstado(book.isEstado());


        return  bookRepository.save(updatedBook);
    }
}
