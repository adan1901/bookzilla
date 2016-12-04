package com.bookzilla.book;

import com.bookzilla.dao.BookDao;
import com.bookzilla.model.Book;
import com.bookzilla.model.User;
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


    @Override
    public void registerBook(Book book) throws Exception {

        logger.debug("Register book in the storage system " + book);

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
        //TODO
        return super.retrieveBooksFromUserLibrary(user);
    }

    @Override
    public List<Book> retrieveBooksFromUserLibrary(int userId) {
        //TODO
        return super.retrieveBooksFromUserLibrary(userId);
    }

    @Override
    public Book getBookWithId(int bookId) {

        //TODO

        return super.getBookWithId(bookId);
    }

    @Override
    public void seek_path(ArrayList<String> till_now, ArrayList<String> to_seek, ArrayList<Book> ret, File dir){
        if (to_seek.size() == 0){
          ret.add(new Book(Integer.parseInt(till_now.get(0)), till_now.get(1), till_now.get(2),till_now.get(3), till_now.get(4),
                  till_now.get(5), till_now.get(6), Integer.parseInt(till_now.get(7)), Integer.parseInt(till_now.get(8))));
          return;
      }
      String criterion;
      if (to_seek.get(0) != null){
          criterion = new String(to_seek.get(0).toLowerCase());
      }
      else{
          criterion = null;
      }
      to_seek.remove(0);
      for (File dir_nou : dir.listFiles() ){
          if (criterion == null || dir_nou.getName().toLowerCase().contains(criterion)){
              till_now.add(dir_nou.getName());
              seek_path(till_now, to_seek, ret, dir_nou);
              till_now.remove(till_now.size() - 1);
          }
      }
      to_seek.add(0, criterion);
    }

    @Override
    public List<Book> findBooks(Integer id, Integer ownerId, Integer renterId, String title, String author, String publisher,
                                String category, String language, String description, String location){
        try{
            File dir_mare = new File("books");
            ArrayList<String> till_now = new ArrayList<String>();
            ArrayList<String> to_seek = new ArrayList<String>();
            to_seek.add((id == null)?null:id.toString());
            to_seek.add(category);
            to_seek.add(location);
            to_seek.add(author);
            to_seek.add(publisher);
            to_seek.add(title);
            to_seek.add(language);
            to_seek.add((ownerId == null)?null:ownerId.toString());
            to_seek.add((renterId == null)?null:renterId.toString());
            ArrayList<Book> booklist = new ArrayList<Book>();
            seek_path(till_now, to_seek, booklist, dir_mare);
            return booklist;
        } catch(Exception e){
            e.printStackTrace();
            return new ArrayList<Book>();
        }
    }
}
