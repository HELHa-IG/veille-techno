package org.helha.controllers;

import org.helha.models.Book;
import org.helha.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRESTController {

    @Autowired
    public IBookService service;

    @GetMapping
    public Page<Book> getBooks() {
        return service.findAll();
    }

}
