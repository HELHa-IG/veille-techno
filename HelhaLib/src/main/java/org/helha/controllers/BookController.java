package org.helha.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.helha.models.Book;
import org.helha.repos.IBookRepository;
import org.helha.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    public IBookService service;

    @GetMapping
    public String getBooks(Model model,String keyword) throws JsonProcessingException {
        Page<Book> books = null;
        if(keyword != null){
            books = this.service.find(keyword);
            model.addAttribute("keyword",keyword);
        }else{
            books = this.service.findAll();
            model.addAttribute("keyword","");
        }

        for (Book book : books.getContent()) {
            ObjectMapper mapper = new ObjectMapper();
            book.setJsonFormat(mapper.writeValueAsString(book));
        }




        model.addAttribute("books",books);
        return "books";
    }
}
