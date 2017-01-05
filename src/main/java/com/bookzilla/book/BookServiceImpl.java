package com.bookzilla.book;

import com.bookzilla.dao.BookDao;
import com.bookzilla.model.Book;
import com.bookzilla.model.User;
import com.bookzilla.repository.BookRepository;
import com.bookzilla.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;

/**
 * Created by adinu on 12/4/16.
 */
@Service
public class BookServiceImpl extends BookService {

    private static final Logger logger = Logger.getLogger(BookServiceImpl.class);

    @Autowired
    BookDao bookDao;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void registerBook(Book book) throws Exception {

        logger.debug("Register book in DB" + book);

        if (book == null) { throw new UnsupportedOperationException(); }

        bookDao.saveObject(book);
    }

    @Override
    public void addBookToUserLibrary(User user) {
        //TODO
        super.addBookToUserLibrary(user);
    }

    @Override
    public void addBookToUserLibrary(int userId) {
        //TODO
        super.addBookToUserLibrary(userId);
    }

    @Override
    public List<Book> findBooksWithHighestRank(int retBookLimit) {
        //TODO
        return super.findBooksWithHighestRank(retBookLimit);
    }

    @Override
    public List<Book> retrieveBooksFromUserLibrary(User user) {

        try {

            return new ArrayList<>(user.getBooksOwned());

        } catch (Exception e) {
            logger.error(e);
            return new ArrayList<>();
        }
    }

    @Override
    public List<Book> retrieveBooksFromUserLibrary(Long userId) {
        try {

            User user = userRepository.findById(userId);

            return new ArrayList<>(user.getBooksOwned());

        } catch (Exception e) {
            logger.error(e);
            return new ArrayList<>();
        }
    }

    @Override
    public Book findBookById(Long id) {

        try {
            return bookRepository.findById(id);

        } catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    @Override
    public List<Book> retrieveAllBooks() {

        try {
            return bookRepository.findAll();

        } catch (Exception e) {
            logger.error(e);
        }

        return null;

    }
}
