package com.bookzilla.service;

import com.bookzilla.dao.UserDao;
import com.bookzilla.model.User;
import com.bookzilla.repository.UserRepository;
import com.bookzilla.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

/**
 * Created by adinu on 12/4/16.
 */
@Service
public class UserServiceImpl extends UserService {

    private static final Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    UserDao userDao;

    @Autowired
    UserRepository userRepository;

    public void addUser(User user) throws Exception {

        logger.debug("Adding user " + user);
        if (user == null) { throw new UnsupportedOperationException("User cannot be null"); }

        userDao.saveObject(user);
    }

    @Override
    public User findByUsername(String username) {

        try {
            return userRepository.findByUsername(username);

        } catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    @Override
    public List<User> listAllUsers() {

        try {
            return userRepository.findAll();
        } catch (Exception e) {
            logger.error(e);
            return new ArrayList<User>();
        }
    }

}
