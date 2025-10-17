package com.proyecto.crud_Library.controller;

import com.proyecto.crud_Library.entity.Book;
import com.proyecto.crud_Library.service.BookServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1")
public class BookController {

    private final BookServiceImpl bookService;


    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/Get")
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok().body(bookService.findAll());
    }

    @GetMapping("GetById/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        if (bookService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }else {
            Book book = bookService.findById(id);
            return ResponseEntity.ok().body(book);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Book> save(@RequestBody Book book) {
        return  ResponseEntity.ok(bookService.save(book));
    }


    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id) {
        bookService.deleteById(id);
        return null;
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Book> put(@PathVariable Long id, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.update(id, book));
    }



}
