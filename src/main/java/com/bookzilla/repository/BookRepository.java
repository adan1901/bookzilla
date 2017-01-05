package com.bookzilla.repository;

import com.bookzilla.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by adinu on 1/5/17.
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findById(Long id);

}
