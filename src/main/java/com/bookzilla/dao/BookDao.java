package com.bookzilla.dao;

import com.bookzilla.service.BookService;
import com.bookzilla.model.Book;
import com.bookzilla.repository.BookRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by adinu on 12/4/16.
 */
@Component
public class BookDao implements BaseDao {

    private static final Logger logger = Logger.getLogger(BookDao.class);

    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;

    @Override
    public boolean saveObject(Object object) {

        Book book = null;
        if (object instanceof Book) {
            book = (Book) object;
        }

        if (book == null) { return false; }

        return save(book);
    }

    private boolean save(Book book) {

        try {

            bookRepository.save(book);

            return true;

        } catch (Exception e) {
            logger.error(e);
            return false;
        }
    }
}
