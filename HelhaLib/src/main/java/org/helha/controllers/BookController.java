package org.helha.controllers;

import org.helha.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    public ArrayList<Book> books;

    @GetMapping
    public String getBooks(Model model) {
        model.addAttribute("books",books);
        return "books";
    }
}
