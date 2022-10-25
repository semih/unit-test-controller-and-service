package com.unittest.controllerandservice.service;

import com.unittest.controllerandservice.model.Book;

import java.util.Collection;
import java.util.Optional;
public interface BookService {
    Collection<Book> findAll();
    Book create(Book book);
    Optional<Book> find(String isbn);
}