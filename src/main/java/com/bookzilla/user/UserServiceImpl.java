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

    private void seekPath(ArrayList<String> till_now, ArrayList<String> to_seek,
                          ArrayList<User> ret, File dir) {
        if (to_seek.size() == 0) {
            ret.add(new User(Integer.valueOf(till_now.get(0)), till_now.get(1), till_now.get(2),
                    till_now.get(3), till_now.get(4), till_now.get(5)));
            return;
        }
        String criterion;
        if (to_seek.get(0) != null) {
            criterion = new String(to_seek.get(0).toLowerCase());
        }
        else {
            criterion = null;
        }
        to_seek.remove(0);
        for (File dir_nou : dir.listFiles() ) {
            if (criterion == null || dir_nou.getName().toLowerCase().contains(criterion)) {
                till_now.add(dir_nou.getName());
                if (to_seek.size() == 0)
                    try {
                        String password;
                        Scanner scanner = new Scanner(dir_nou);
                        password = scanner.next();
                        till_now.add(password);
                        scanner.close();
                    } catch (Exception e) {
                        logger.debug(e);
                        till_now.add("null");
                    }
                seekPath(till_now, to_seek, ret, dir_nou);
                if (to_seek.size() == 0)
                    till_now.remove(till_now.size() - 1);
                till_now.remove(till_now.size() - 1);
            }
        }
        to_seek.add(0, criterion);
    }

    @Override
    public User findUserByUsername(String username) {

        try {
            File dir_mare = new File("users");
            ArrayList<String> till_now = new ArrayList<String>();
            ArrayList<String> to_seek = new ArrayList<String>();
            to_seek.add("");
            to_seek.add(username);
            to_seek.add("");
            to_seek.add("");
            to_seek.add("");
            ArrayList<User> userList = new ArrayList<User>();
            seekPath(till_now, to_seek, userList, dir_mare);
            return userList.get(0);

        } catch (Exception e) {
            logger.error(e);
            return new User();
        }
    }

    @Override
    public List<User> listAllUsers() {

        try {
            File dir_mare = new File("users");
            ArrayList<String> till_now = new ArrayList<String>();
            ArrayList<String> to_seek = new ArrayList<String>();
            to_seek.add("");
            to_seek.add("");
            to_seek.add("");
            to_seek.add("");
            to_seek.add("");
            ArrayList<User> userList = new ArrayList<User>();
            seekPath(till_now, to_seek, userList, dir_mare);
            return userList;

        } catch (Exception e) {
            logger.error(e);
            return new ArrayList<User>();
        }
    }
}
