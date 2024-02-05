package com.asmb.training.services.book_finder;

import com.asmb.training.models.Book;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookFinderInterface {

    Optional<Book> getBookById(Long id);

    List<Book> findBooksNewerThanDate(Map<String, String> params);

}
