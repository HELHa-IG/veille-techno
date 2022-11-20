package org.helha.services;

import org.helha.models.Book;
import org.springframework.data.domain.Page;

public interface IBookService {
    public Page<Book> findAll();
    public Page<Book> findAll(int pageSize, int offset, String sortBy);
    public Page<Book> find(String keyword);
    public Book add(Book member);
}
