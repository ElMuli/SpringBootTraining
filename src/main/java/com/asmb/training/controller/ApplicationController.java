package com.asmb.training.controller;


import com.asmb.training.models.Book;
import com.asmb.training.services.book_finder.BookFinderInterface;
import com.asmb.training.services.other_task.OtherTasksInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value = "/capgemini/test")
public class ApplicationController {

    private final BookFinderInterface bookFinderInterface;
    private final OtherTasksInterface otherTasksInterface;

    @Autowired
    public ApplicationController(BookFinderInterface bookFinderInterface, OtherTasksInterface otherTasksInterface) {

        this.bookFinderInterface = bookFinderInterface;
        this.otherTasksInterface = otherTasksInterface;


    }

    @GetMapping(value = "/book/{id}", produces = "application/json")
    public @ResponseBody Book getBookById(@PathVariable Long id){

        log.info("recibido");


        CompletableFuture.runAsync(otherTasksInterface::startUselessParallelProcess);

        Optional<Book> book = bookFinderInterface.getBookById(id);

        return book.orElseGet(Book::new);

    }


    @GetMapping(value = "/books", produces = "application/json")
    public @ResponseBody List<Book> getBookById(@RequestParam Map<String, String> params){

        log.info("Mapa de valores recibido: {}", params);

        return bookFinderInterface
                .findBooksNewerThanDate(params)
                .stream()
                .peek(book -> book.setAuthor(book.getAuthor().toUpperCase()))
                .peek(book -> book.setReference(book.getReference().toUpperCase()))
                .collect(Collectors.toList());

    }

    @GetMapping
    public ResponseEntity<String> infiniteEndpoint() {
        while (true) {
            // Hacer algo infinito, como enviar respuestas continuas
            // En este ejemplo, solo se imprime un mensaje en la consola
            System.out.println("Respondiendo infinitamente...");

            // Pausa de 1 segundo para evitar consumir toda la CPU
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


}
