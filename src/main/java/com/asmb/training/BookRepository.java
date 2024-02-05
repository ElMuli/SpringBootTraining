package com.asmb.training;

import com.asmb.training.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByPublishingDateGreaterThan(LocalDateTime publishingDate);

}
