package com.bookzilla.dao;

import com.bookzilla.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static com.bookzilla.utils.PasswordEncryptor.decode;

/**
 * Created by adinu on 12/4/16.
 */
@Component
public class UserDao implements BaseDao {

    private static final Logger logger = Logger.getLogger(UserDao.class);

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

        try{
            File file = new File("users//" + user.getId() + "//" + user.getUsername() + "//" +
                    user.getEmail() + "//" + user.getFirstName() + "//" + user.getLastName());
            if (!file.getParentFile().exists()) { file.getParentFile().mkdirs(); }
            if (file.exists()) { return true; }

            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.println(user.getPassword());
            writer.close();

        } catch (IOException e){
            logger.error(e);
            return false;
        }
        return true;
    }
}
