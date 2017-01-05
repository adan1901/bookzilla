package com.bookzilla.repository;

import com.bookzilla.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adinu on 1/3/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findById(Long id);
}
