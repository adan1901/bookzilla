package com.bookzilla.dao;

import com.bookzilla.model.Category;
import com.bookzilla.repository.CategoryRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by adinu on 1/5/17.
 */
@Component
public class CategoryDao implements BaseDao {

    private static final Logger logger = Logger.getLogger(CategoryDao.class);

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public boolean saveObject(Object object) {

        Category category = null;
        if (object instanceof Category) {
            category = (Category) object;
        }

        if (category == null) { return false; }

        return save(category);
    }

    private boolean save(Category category) {

        try {

            categoryRepository.save(category);

            return true;

        } catch (Exception e) {
            logger.error(e);
            return false;
        }
    }
}
