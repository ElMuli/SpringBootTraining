package com.asmb.training.services.book_finder;

import com.asmb.training.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public interface BookFinderInterface {

    Optional<Book> getBookById(Long id);

    List<Book> findBooksNewerThanDate(Map<String, String> params);

}
