package org.helha.models;

import java.math.BigDecimal;

public class Book {

    private int id;
    private String name;
    private String author;
    private String isbn;
    private String description;
    private BigDecimal price;

    private String imageURL;

    public Book(int id, String name, String author, String isbn, BigDecimal price,String imageURL) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
