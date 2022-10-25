package com.unittest.controllerandservice.service.impl;

import com.unittest.controllerandservice.model.Book;
import com.unittest.controllerandservice.repository.BookRepository;
import com.unittest.controllerandservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class InMemoryBookService implements BookService {
    private Map<String, Book> books = new ConcurrentHashMap<>();

    private final BookRepository bookRepository;

    @Override
    public Collection<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book create(Book book) {
        //bookRepository.save(book);
        books.put(book.getIsbn(), book);
        return book;
    }

    @Override
    public Optional<Book> find(String isbn) {
        //bookRepository.findById(isbn);
        return Optional.ofNullable(books.get(isbn));
    }
}