package com.unittest.controllerandservice.repository;

import com.unittest.controllerandservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
