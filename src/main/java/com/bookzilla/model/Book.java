package com.bookzilla.model;

/**
 * Created by adinu on 12/4/16.
 */
public class Book {

    private static int SEQUENCE_NUM = 0;

    private int id;

    private int ownerId;

    private int renterId;

    private double rank;

    private String title;

    private String author;

    private String publisher;

    private String category;

    private String language;

    private String description;

    private String location;

    private String urlLocation;

    public Book() {

        super();
        this.id = Book.SEQUENCE_NUM++;
    }

    public Book(String category, String location, String author, String publisher,
                String title, String language, int ownerId, int renderId, String urlLocation,
                String description, int rank) {

        super();
        this.id = ++Book.SEQUENCE_NUM;
        this.ownerId = ownerId;
        this.rank = rank;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.language = language;
        this.urlLocation = urlLocation;
        this.description = description;
    }

    public Book(int id, String category, String location, String author, String publisher,
                String title, String language, int ownerId, int renderId, String urlLocation, String description) {
        this.id = id;
        this.ownerId = ownerId;
        this.renterId = renterId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.language = language;
        this.location = location;
        this.description = description;
        this.urlLocation = urlLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getRenterId() {
        return renterId;
    }

    public void setRenterId(int renterId) {
        this.renterId = renterId;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getUrlLocation() {
        return urlLocation;
    }

    public void setUrlLocation(String urlLocation) {
        this.urlLocation = urlLocation;
    }

    @Override
    public int hashCode() {
        final int prime = 100007;
        int result = 1;
        result = prime * result + id;

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
                "Book [id=%s, rank=%s, title=%s, author=%s, publisher=%s, category=%s, language=%s, location=%s, description=%s]",
                id, rank, title, author, publisher, category, language, location, description);
    }
}
