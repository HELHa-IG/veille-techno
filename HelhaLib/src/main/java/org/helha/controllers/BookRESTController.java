package org.helha.controllers;

import org.helha.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRESTController {

    @Autowired
    public ArrayList<Book> books;

    @GetMapping
    public ArrayList<Book> getBooks() {
        return this.books;
    }

}
