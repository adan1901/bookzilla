package com.bookzilla.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by adinu on 1/5/17.
 */
@Entity
@Table(name = "bz_category")
public class Category {

    private Long id;

    private String name;

    private Book book;

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "bz_book_category",
            inverseJoinColumns = @JoinColumn(name = "book_id"),
            joinColumns = @JoinColumn(name = "category_id"))
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return String.format(
                "Category[id=%s, name=%s]", id, name);
    }

}
