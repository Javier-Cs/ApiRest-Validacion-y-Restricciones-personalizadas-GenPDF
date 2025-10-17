package com.proyecto.crud_Library.controller;

import com.proyecto.crud_Library.dto.BookDtoGet;
import com.proyecto.crud_Library.dto.BookDtoPost;
import com.proyecto.crud_Library.dto.BookMapper;
import com.proyecto.crud_Library.entity.Book;
import com.proyecto.crud_Library.service.BookServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1")
public class BookController {

    private final BookServiceImpl bookService;
    // implementamos el mapper
    private final BookMapper bookMapper;


    public BookController(BookServiceImpl bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }


    // los metodos deben de devolver un DTO
    @GetMapping("/Get")
    public ResponseEntity<List<BookDtoGet>> findAll() {
        return ResponseEntity.ok().body(bookService.findAll());
    }

    @GetMapping("GetById/{id}")
    public ResponseEntity<BookDtoGet> findById(@PathVariable Long id) {
        if (bookService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }else {
            BookDtoGet book = bookService.findById(id);
            return ResponseEntity.ok().body(book);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<BookDtoPost> save(@RequestBody BookDtoPost bookPost) {
        BookDtoPost bookDtoPost = bookService.save(bookPost);
        return  ResponseEntity.ok().body(bookDtoPost);
    }


    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id) {
        bookService.deleteById(id);
        return null;
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<BookDtoPost> put(@PathVariable Long id, @RequestBody BookDtoPost book) {
        return ResponseEntity.ok(bookService.update(id, book));
    }



}
