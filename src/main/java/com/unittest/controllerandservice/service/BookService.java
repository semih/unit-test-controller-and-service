package com.unittest.controllerandservice.service;

import com.unittest.controllerandservice.model.Book;

import java.util.Optional;
public interface BookService {
    Iterable<Book> findAll();
    Book create(Book book);
    Optional<Book> find(String isbn);
}