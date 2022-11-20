package org.helha.repos;

import org.helha.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBookRepository extends JpaRepository<Book, Integer>{
    Page<Book> findAll(Pageable pageable);

    @Query("SELECT b FROM Book b WHERE CONCAT(upper(b.name),upper(b.author),upper(b.isbn)) like CONCAT('%',upper(?1),'%')")
    Page<Book> find(String keyword,Pageable pageable);
}
