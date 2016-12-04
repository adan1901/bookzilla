package com.bookzilla.book;

import com.bookzilla.model.Book;
import com.bookzilla.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adinu on 12/4/16.
 */
public abstract class BookService {

    /**
     * Register book within the storage system
     * Will not be allocated to any user
     * @param book
     * @throws Exception
     */
    public void registerBook(Book book) throws Exception {};

    public void addBookToUserLibrary(User user) {};

    public void addBookToUserLibrary(int userId) {};

    public List<Book> findBooksWithHighestRank(int retBookLimit) {
        return new ArrayList<>();
    }

    public List<Book> retrieveBooksFromUserLibrary(User user) {
        return new ArrayList<>();
    }

    public List<Book> retrieveBooksFromUserLibrary(int userId) {
        return new ArrayList<>();
    }

    public Book getBookWithId(int bookId) { return new Book(); }

}
