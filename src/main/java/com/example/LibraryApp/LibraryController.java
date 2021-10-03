package com.example.LibraryApp;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class LibraryController {

    private final BooksService booksservice;

    public LibraryController(BooksService booksservice){
        this.booksservice = booksservice;
    }
    @PostMapping
    public ResponseEntity addBooks(@RequestBody Books books){
        booksservice.addBooks(books);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
    @PutMapping
    public ResponseEntity updateBooks(@RequestBody Books books){
        booksservice.updateBooks(books);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<List<Books>> getAllBooks(){
       return ResponseEntity.ok(booksservice.getAllBooks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable String id){
        booksservice.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
