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

    public String escapeBuggySymbols(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '.') {
                sb.append(" ");
                continue;
            } else if (s.charAt(i) == ':') {
                sb.append("  ");
                continue;
            } else if (s.charAt(i) == '/') {
                sb.append("   ");
                continue;
            }

            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public String unescapeBuggySymbols(String s) {

        logger.debug(".unescapeBuggySymbols " + "s: " + s);

        StringBuilder sb = new StringBuilder();

        char space = ' ';
        int spacesNum, offset;
        for (int i = 0; i < s.length(); i++) {
            spacesNum = 0;
            offset = i;
            while ( (s.charAt(offset) == space) && (offset < s.length()) ) {
                offset++;
                spacesNum++;
            }
            if (spacesNum == 8) {
                sb.append("://");
                i = offset - 1;
                continue;
            } else if (spacesNum == 1) {
                sb.append(".");
                i = offset - 1;
                continue;
            } else if (spacesNum == 3) {
                sb.append("/");
                i = offset - 1;
                continue;
            }

            logger.debug("appending char " + s.charAt(i));
            sb.append(s.charAt(i));
        }
        logger.debug(".unescapeBuggySymbols " + " after unescape: " + sb.toString());

        return sb.toString();
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
        return findBooks(null, userId, null, null, null, null, null, null, null, null, null);
    }

    @Override
    public Book getBookWithId(int bookId) {
        return findBooks(bookId, null, null, null, null, null, null, null, null, null, null).get(0);
    }

    @Override
    public void seekPath(ArrayList<String> till_now, ArrayList<String> to_seek, ArrayList<Book> ret, File dir){
        if (to_seek.size() == 0) {
            ret.add(new Book(Integer.parseInt(till_now.get(0)), till_now.get(1), till_now.get(2),till_now.get(3), till_now.get(4),
              till_now.get(5), till_now.get(6), Integer.parseInt(till_now.get(7)), Integer.parseInt(till_now.get(8)),
              till_now.get(9), till_now.get(10)));
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
              if (to_seek.size() == 0)
                  try {
                      String description;
                      Scanner scanner = new Scanner(dir_nou);
                      description = scanner.nextLine();
                      till_now.add(description);
                      scanner.close();
                  } catch (Exception e) {
                      logger.debug(e);
                      till_now.add("null description");
                  }
              seekPath(till_now, to_seek, ret, dir_nou);
              if (to_seek.size() == 0)
                  till_now.remove(till_now.size() - 1);
              till_now.remove(till_now.size() - 1);
          }
      }
      to_seek.add(0, criterion);
    }

    @Override
    public List<Book> findBooks(Integer id, Integer ownerId, Integer renterId, String title, String author, String publisher,
                                String category, String language, String description, String location, String imgUrl){
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
            to_seek.add(imgUrl);
            ArrayList<Book> bookList = new ArrayList<Book>();

            seekPath(till_now, to_seek, bookList, dir_mare);

            logger.debug("Search returned " + bookList.size() + " results.");

            for (Book b : bookList) {
                b.setUrlLocation(unescapeBuggySymbols(b.getUrlLocation()));
            }
            return bookList;
        } catch(Exception e){
            e.printStackTrace();
            return new ArrayList<Book>();
        }
    }

    @Override
    public List<Book> retrieveAllBooks() {

        return findBooks(null, null, null, null, null, null, null, null, null, null, null);
    }

    @Override
    public int getNextSequenceNum() {
        int seq_num = Book.SEQUENCE_NUM;

        try {
            File user_seq = new File("book_sequence");
            Scanner scanner = new Scanner(user_seq);
            seq_num = Integer.parseInt(scanner.next());
            scanner.close();

            return ++seq_num;
        } catch (Exception e) {
            logger.error(e);
            return ++seq_num;
        }
    }

    @Override
    public void saveSequenceNum(int sequenceNum) {

        try {
            File file = new File("book_sequence");

            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.println(sequenceNum);
            writer.close();

        } catch (Exception e) {
            logger.error(e);
        }
    }
}
