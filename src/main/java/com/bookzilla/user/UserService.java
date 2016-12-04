package com.bookzilla.user;

import com.bookzilla.dao.UserDao;
import com.bookzilla.model.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adinu on 12/4/16.
 */
public abstract class UserService {

    public void addUser(User user) throws Exception {};

    public void seek_path(ArrayList<String> till_now, ArrayList<String> to_seek, ArrayList<User> ret, File dir){}
    //TODO
    public List<User> listAllUsers() {
        return new ArrayList<>();
    }

}
