package com.asmb.training.controller;

import com.asmb.training.models.Book;
import com.asmb.training.services.book_finder.BookFinderInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationControllerTest {

    @Mock
    private BookFinderInterface bookFinderInterface;

    @InjectMocks
    private ApplicationController applicationController;

    @Test
    public void testGetBookById() {
        // Arrange
        Long bookId = 1L;
        Book book = new Book();
        book.setId(bookId);
        when(bookFinderInterface.getBookById(bookId)).thenReturn(Optional.of(book));

        // Act
        Book result = applicationController.getBookById(bookId);

        // Assert
        assertNotNull(result);
        assertEquals(bookId, result.getId());
    }

    @Test
    public void testGetBooksByDate() {
        // Arrange
        Map<String, String> params = new HashMap<>();
        params.put("year", "2023");
        params.put("month", "2");
        params.put("day", "1");
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        when(bookFinderInterface.findBooksNewerThanDate(params)).thenReturn(books);

        // Act
        List<Book> result = applicationController.getBookById(params);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}
