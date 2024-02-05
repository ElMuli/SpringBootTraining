package com.asmb.training.controller;


import com.asmb.training.models.Book;
import com.asmb.training.services.book_finder.BookFinderInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/capgemini/test")
public class ApplicationController {

    private BookFinderInterface bookFinderInterface;

    @Autowired
    public ApplicationController(BookFinderInterface bookFinderInterface) {

        this.bookFinderInterface = bookFinderInterface;


    }

    @GetMapping(value = "/book/{id}", produces = "application/json")
    public @ResponseBody Book getBookById(@PathVariable Long id){

        log.info("recibido");

        Optional<Book> book = bookFinderInterface.getBookById(id);

        return book.orElseGet(Book::new);

    }


    @GetMapping(value = "/books", produces = "application/json")
    public @ResponseBody List<Book> getBookById(@RequestParam Map<String, String> params){

        log.info("Mapa de valores recibido: {}", params);

        log.info("mes consultado: {}", params.get("month"));

        return bookFinderInterface.findBooksNewerThanDate(params);

    }


}
