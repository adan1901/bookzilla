package com.bookzilla.user;

import com.bookzilla.dao.UserDao;
import com.bookzilla.model.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adinu on 12/4/16.
 */
public abstract class UserService {

    public void addUser(User user) throws Exception {};

    //TODO
    public List<User> listAllUsers() {
        return new ArrayList<>();
    }

}
