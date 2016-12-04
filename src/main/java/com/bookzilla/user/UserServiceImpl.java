package com.bookzilla.user;

import com.bookzilla.dao.UserDao;
import com.bookzilla.model.User;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        // TODO
        return super.listAllUsers();
    }
}
