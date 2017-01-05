package com.bookzilla.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by adinu on 12/4/16.
 */
@Entity
@Table(name = "bz_book")
public class Book {

    private Long id;

    private double rank;

    private String title;

    private String author;

    private String publisher;

    private String language;

    private String description;

    private String location;

    private String url;

    private User ownerUser;

    private User renterUser;

    private Set<Category> categories;

    public Book() {

        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "bz_user_books_owned",
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            joinColumns = @JoinColumn(name = "book_id"))
    public User getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(User ownerUser) {
        this.ownerUser = ownerUser;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "bz_user_books_rented",
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            joinColumns = @JoinColumn(name = "book_id"))
    public User getRenterUser() {
        return renterUser;
    }

    public void setRenterUser(User renterUser) {
        this.renterUser = renterUser;
    }

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }


    @Override
    public int hashCode() {
        final int prime = 100007;
        int result = 1;
        result = prime * result + id.intValue();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (id != other.getId())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "Book [id=%s, rank=%s, title=%s, author=%s, publisher=%s, language=%s, location=%s, description=%s, url=%s]",
                id, rank, title, author, publisher, language, location, description, url);
    }
}
