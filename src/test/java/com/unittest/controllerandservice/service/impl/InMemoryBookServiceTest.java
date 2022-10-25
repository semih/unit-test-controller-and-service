package com.unittest.controllerandservice.service.impl;

import com.unittest.controllerandservice.model.Book;
import com.unittest.controllerandservice.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InMemoryBookServiceTest {
    private Book book;
    @InjectMocks
    private InMemoryBookService inMemoryBookService;
    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    public void initializeObjects(){
        //bookRepository = Mockito.mock(BookRepository.class);
        //bookService = new InMemoryBookService(bookRepository);
        book = new Book("1309", "Harry Potter", "J.K.Rowling");
    }

    @DisplayName("JUnit test for getAllBooks method")
    @Test
    void findAll() {
        // given
        var expectedBook1 = new Book("1245", "Lord of the Rings", "Tolkien");
        var expectedBook2 = new Book("1309", "Harry Potter", "J.K.Rowling");
        List<Book> expectedBookList = List.of(book, expectedBook1, expectedBook2);

        // when -  action or the behaviour that we are going test
        when(bookRepository.findAll()).thenReturn(expectedBookList);

        // then - verify the output
        Collection<Book> bookCollection = inMemoryBookService.findAll();
        assertThat(bookCollection.size()).isEqualTo(expectedBookList.size());
        assertThat(bookCollection).isNotNull();
        verify(bookRepository, times(1)).findAll();
    }
}