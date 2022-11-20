package org.helha.services;

import org.helha.models.Book;
import org.helha.repos.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
@Primary
public class BookServiceSQLImpl implements IBookService {

    @Value("${helhafit.api.paging.pageSize:5}")
    public String DEFAULT_PAGESIZE;

    @Value("${helhafit.api.paging.offset:0}")
    public String DEFAULT_OFFSET;

    @Autowired
    IBookRepository repository;

    public Page<Book> findAll() {
        return this.findAll(
                Integer.valueOf(DEFAULT_PAGESIZE),
                Integer.valueOf(DEFAULT_OFFSET),
                "");
    }

    @Override
    public Page<Book> findAll(int pageSize, int offset, String sortBy) {
        Page page = null;
        if (sortBy != null && !sortBy.isEmpty()) {
            page = this.repository.findAll(
                    PageRequest.of(offset,
                            pageSize,
                            Sort.by(parseOrderByString(sortBy))
                    )
            );
        } else {
            page = this.repository.findAll(
                    PageRequest.of(offset,
                            pageSize
                    )
            );
        }

        return page;
    }

    @Override
    public Page<Book> find(String keyword) {
        if (keyword != null) {
            return this.repository.find(keyword,PageRequest.of(
                            Integer.valueOf(DEFAULT_OFFSET),
                            Integer.valueOf(DEFAULT_PAGESIZE)
                    )
                    );
        } else {
            return this.findAll();
        }
    }

    public Book add(Book book) {
        if (book != null) {
            return this.repository.save(book);
        }
        return null;
    }

    private Sort.Order[] parseOrderByString(String sortBy) {
        ArrayList<Sort.Order> orders = new ArrayList<>();
        Arrays.stream(sortBy.split(";")).forEach(sortByCouple -> {
            String[] columnDirection = sortByCouple.trim().split(" ");
            if (columnDirection.length > 0 && columnDirection.length <= 2) {
                String direction = Sort.Direction.ASC.toString();
                if (columnDirection.length > 1) {
                    direction = columnDirection[1].trim();
                }
                orders.add(new Sort.Order(Sort.Direction.fromString(direction), columnDirection[0].trim()));
            }
        });

        return orders.stream().toArray(Sort.Order[]::new);

    }
}
