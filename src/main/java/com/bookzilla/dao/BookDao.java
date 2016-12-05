package com.bookzilla.dao;

import com.bookzilla.model.Book;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by adinu on 12/4/16.
 */
@Component
public class BookDao implements BaseDao {

    private static final Logger logger = Logger.getLogger(BookDao.class);

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

        File file = new File("books//" + book.getId() + "//" + book.getCategory()+ "//" +
                book.getLocation()+ "//" + book.getAuthor() + "//" + book.getPublisher() + "//" +
                book.getTitle() + "//" + book.getLanguage() + "//" + book.getOwnerId() + "//" +
                book.getRenterId() + "//" + book.getUrlLocation());
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try{
            FileWriter writer = new FileWriter(file);
            writer.write(book.getDescription());
            writer.close();

        } catch(IOException e){
            logger.debug(e);
            return false;
        }

        return true;
    }
}
