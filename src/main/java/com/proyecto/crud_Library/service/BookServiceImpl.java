package com.proyecto.crud_Library.service;

import com.proyecto.crud_Library.dto.BookDtoGet;
import com.proyecto.crud_Library.dto.BookDtoPost;
import com.proyecto.crud_Library.dto.BookMapper;
import com.proyecto.crud_Library.entity.Book;
import com.proyecto.crud_Library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    // loa servicios tambien deberian de devolver un DTO
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDtoGet> findAll() {

        List<BookDtoGet> bookDtoGets = new ArrayList<>();
        for(Book book : bookRepository.findAll()){
            bookDtoGets.add(bookMapper.BooktoDtoGet(book));
        }
        return bookDtoGets;
    }

    @Override
    public BookDtoGet findById(Long id) {
        Book bookEmtity = bookRepository.findById(id).orElse(null);
        BookDtoGet bookDto = bookMapper.BooktoDtoGet(bookEmtity);
        return bookDto;
    }

    @Override
    public BookDtoPost save(BookDtoPost bookDto) {
        Book bookentity = bookMapper.dtoPostToBook(bookDto);
        Book saveEntity = bookRepository.save(bookentity);
        return bookMapper.BooktoDtoPost(saveEntity);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDtoPost update(Long id , BookDtoPost book) {
        Book updatedBook = bookRepository.findById(id).orElse(null);

        assert updatedBook != null;
        updatedBook.setTitulo(book.titulo());
        updatedBook.setAutor(book.autor());
        updatedBook.setEditorial(book.editorial());
        updatedBook.setFechaPublicacion(book.fechaPublicacion());
        updatedBook.setNumPage(book.numPage());
        updatedBook.setEstado(book.estado());

        Book savedBook = bookRepository.save(updatedBook);

        return  bookMapper.BooktoDtoPost(savedBook);
    }
}
