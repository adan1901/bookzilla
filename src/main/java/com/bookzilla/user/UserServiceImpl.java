package com.bookzilla.user;

import com.bookzilla.dao.UserDao;
import com.bookzilla.model.User;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by adinu on 12/4/16.
 */
@Service
public class UserServiceImpl extends UserService {

    private static final Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    UserDao userDao;

    public void addUser(User user) throws Exception {

        logger.debug("Adding user " + user);
        if (user == null) { throw new UnsupportedOperationException(); }

        userDao.saveObject(user);
    }
    @Override
    public List<User> listAllUsers() {
        ArrayList<User> ret = new ArrayList<User>();
        Scanner scanner;
        File dir_mare = new File("users");
        String password;
        try {
            for (File id : dir_mare.listFiles())
                for (File username : id.listFiles())
                    for (File email : username.listFiles())
                        for (File firstName : email.listFiles())
                            for (File lastName : firstName.listFiles()) {
                                scanner = new Scanner(lastName);
                                password = scanner.next();
                                ret.add(new User(0, firstName.getName(), lastName.getName(), username.getName(), password, email.getName(), "no_location"));
                            }
        } catch (Exception e){
            e.printStackTrace();
        }
        // TODO
        return ret;
    }
}
