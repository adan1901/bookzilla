package com.bookzilla.book;

import com.bookzilla.dao.BookDao;
import com.bookzilla.model.Book;
import com.bookzilla.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adinu on 12/4/16.
 */
@Service
public class BookServiceImpl extends BookService {

    private static final Logger logger = Logger.getLogger(BookServiceImpl.class);

    @Autowired
    BookDao bookDao;


    @Override
    public void registerBook(Book book) throws Exception {

        logger.debug("Register book in the storage system " + book);

        if (book == null) { throw new UnsupportedOperationException(); }

        bookDao.saveObject(book);
    }

    @Override
    public void addBookToUserLibrary(User user) {
        super.addBookToUserLibrary(user);
    }

    @Override
    public void addBookToUserLibrary(int userId) {
        super.addBookToUserLibrary(userId);
    }

    @Override
    public List<Book> findBooksWithHighestRank(int retBookLimit) {
        return super.findBooksWithHighestRank(retBookLimit);
    }

    @Override
    public List<Book> retrieveBooksFromUserLibrary(User user) {
        return super.retrieveBooksFromUserLibrary(user);
    }

    @Override
    public List<Book> retrieveBooksFromUserLibrary(int userId) {
        return super.retrieveBooksFromUserLibrary(userId);
    }

    @Override
    public Book getBookWithId(int bookId) {
        return super.getBookWithId(bookId);
    }
}
