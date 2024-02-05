package com.asmb.training.services.book_finder;

import com.asmb.training.BookRepository;
import com.asmb.training.models.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class BookFinderImpl implements BookFinderInterface{


    private static final Integer DEFAULT_HOUR = 0;
    private static final Integer DEFAULT_MINUTE = 0;
    private static final Integer DEFAULT_SECOND = 0;

    private BookRepository bookRepository;

    @Autowired
    public BookFinderImpl(BookRepository bookRepository) {

        this.bookRepository = bookRepository;

    }

    @Override
    @Cacheable("books")
    public Optional<Book> getBookById(Long id) {



        try {
            Thread.sleep(5000L);
            return bookRepository.findById(id);

        }catch (Exception e){

            return Optional.empty();
        }

    }

    @Override
    @Cacheable(value = "booksByDate", key = "{#params['year'] ?: 0, #params['month'] ?: 1, #params['day'] ?: 1}")
    public List<Book> findBooksNewerThanDate(Map<String, String> params) {

        Optional<Integer> optionalYear = Optional.ofNullable(params.get("year")).map(Integer::parseInt);
        Optional<Integer> optionalMonth = Optional.ofNullable(params.get("month")).map(Integer::parseInt);
        Optional<Integer> optionalDay = Optional.ofNullable(params.get("day")).map(Integer::parseInt);

        int year = optionalYear.orElse(0);
        int month = optionalMonth.orElse(1);
        int day = optionalDay.orElse(1);

        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, 0, 0);


        return bookRepository.findAllByPublishingDateGreaterThan(localDateTime);
    }


}
