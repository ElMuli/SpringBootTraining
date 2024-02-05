/*
package com.asmb.training.config;

import com.asmb.training.BookRepository;
import com.asmb.training.models.Book;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDateTime;

public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        // Aquí puedes insertar algunos datos de ejemplo
        Book book1 = new Book();
        book1.setAuthor("Autor 1");
        book1.setReference("REF-001");
        book1.setPublishingDate(LocalDateTime.now());

        Book book2 = new Book();
        book2.setAuthor("Autor 2");
        book2.setReference("REF-002");
        book2.setPublishingDate(LocalDateTime.now());

        // Guardar los libros en la base de datos

        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}*/
