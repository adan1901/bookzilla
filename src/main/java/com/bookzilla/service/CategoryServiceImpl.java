package com.bookzilla.service;

import com.bookzilla.dao.CategoryDao;
import com.bookzilla.model.Category;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by adinu on 1/5/17.
 */
@Service
public class CategoryServiceImpl extends CategoryService {

    private static final Logger logger = Logger.getLogger(CategoryService.class);

    @Autowired
    CategoryDao categoryDao;

    public void registerCategory(Category category) throws Exception {

        logger.debug("Registering new category into DB " + category);

        if (category == null) { throw new UnsupportedOperationException("Category cannot be null"); }

        categoryDao.saveObject(category);
    }
}
