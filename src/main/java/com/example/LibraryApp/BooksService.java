package com.example.LibraryApp;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final BooksRepository booksrepository;

    public BooksService(BooksRepository booksrepository){
        this.booksrepository = booksrepository;
    }

    public void addBooks(Books books){
        booksrepository.insert(books);
    }

    public void updateBooks(Books books){
        Books savedBooks = booksrepository.findById(books.getId()).orElseThrow(()-> new RuntimeException(String.format("Cannot Find Expense by ID %s", books.getId())));

        savedBooks.setId(books.getId());
        savedBooks.setName(books.getName());
        savedBooks.setAuthor(books.getAuthor());

        booksrepository.save(books);
    }

    public List<Books> getAllBooks(){
        return booksrepository.findAll();
    }

    public void deleteBook(String id){
        booksrepository.deleteById(id);
    }
}
