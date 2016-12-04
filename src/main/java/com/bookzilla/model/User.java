package com.bookzilla.model;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by adinu on 12/4/16.
 */
public class User {

    private static int SEQUENCE_NUM = 0;

    private int id;

    private double rank;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private String location;

    public User() {
        super();
        this.id = ++User.SEQUENCE_NUM;
    }

    public User(double rank, String firstName, String lastName, String username, String password,
                String email, String location) {

        super();
        this.rank = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public int hashCode() {
        final int prime = 100001;
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
