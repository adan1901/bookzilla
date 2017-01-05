package com.bookzilla.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by adinu on 1/3/17.
 */
@Entity
@Table(name = "bz_role")
public class Role {

    private Long id;

    private String name;

    private Set<User> users;

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

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return String.format(
                "Role[id=%s, name=%s]", id, name);
    }
}
