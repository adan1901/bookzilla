package com.bookzilla.dao;

import com.bookzilla.model.User;
import com.bookzilla.repository.RoleRepository;
import com.bookzilla.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * Created by adinu on 12/4/16.
 */
@Component
public class UserDao implements BaseDao {

    private static final Logger logger = Logger.getLogger(UserDao.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public boolean saveObject(Object object) {

        User user = null;
        if (object instanceof User) {
            user = (User) object;
        }

        if (user == null) { return false; }

        return save(user);
    }

    private boolean save(User user) {

        try {
            user.setRoles(new HashSet<>(roleRepository.findAll()));
            userRepository.save(user);

            return true;
        } catch (Exception e) {
            logger.error(e);
            return false;
        }

    }
}
