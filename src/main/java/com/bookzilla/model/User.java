package com.bookzilla.model;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by adinu on 12/4/16.
 */
@Entity
@Table(name = "bz_user")
public class User {

    private Long id;

    private double rank;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String passwordConfirm;

    private String email;

    private String location;

    private Set<Role> roles;

    private Set<Book> booksOwned;

    private Set<Book> booksRented;

    public User() {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bz_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @OneToMany(mappedBy = "ownerUser", fetch = FetchType.EAGER)
    public Set<Book> getBooksOwned() {
        return booksOwned;
    }

    public void setBooksOwned(Set<Book> booksOwned) {
        this.booksOwned = booksOwned;
    }

    @OneToMany(mappedBy = "renterUser", fetch = FetchType.EAGER)
    public Set<Book> getBooksRented() {
        return booksRented;
    }

    public void setBooksRented(Set<Book> booksRented) {
        this.booksRented = booksRented;
    }

    @Override
    public int hashCode() {
        final int prime = 100001;
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
        User other = (User) obj;
        if (id != other.getId())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, rank=%s, firstName%s, lastName=%s, username=%s, email=%s, location=%s]",
                id, rank, firstName, lastName, username, email, location);
    }
}
