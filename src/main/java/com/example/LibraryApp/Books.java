package com.example.LibraryApp;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Table(indexes = {
        @Index(name = "idx_books_author", columnList = "author")
})
@Document("Books")
public class Books {
    @Id
    private String id;
    @Field(name = "name")
    private String name;
    @Field(name = "author")
    private String author;

    public Books() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }




}
