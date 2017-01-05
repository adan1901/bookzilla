package com.bookzilla.repository;

import com.bookzilla.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adinu on 1/5/17.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
