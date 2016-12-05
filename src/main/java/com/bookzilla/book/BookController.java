package com.bookzilla.book;

import com.bookzilla.model.Book;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by adinu on 12/4/16.
 */
@Controller
public class BookController {

    private static final Logger logger = Logger.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/add-book", method = RequestMethod.GET)
    public ModelAndView addBook() {

        ModelAndView mv = new ModelAndView("add_book");
        return mv;
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String addBook(@RequestParam String bookTitle,
                          @RequestParam String bookCoverUrl,
                          @RequestParam String bookAuthor,
                          @RequestParam String bookPublisher,
                          @RequestParam String bookLanguage,
                          @RequestParam String bookCateg) {

        logger.debug("Proceed with request of adding a new book");

        Book book = new Book(0, 0, bookTitle, bookAuthor, bookPublisher, bookCateg, bookLanguage);
        book.setLocation("Bucuresti");

        try {
            bookService.registerBook(book);
        } catch (Exception e) {
            logger.error(e);
        }

        return "redirect:/homepage";
    }
}
