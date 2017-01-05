package com.bookzilla.repository;

import com.bookzilla.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adinu on 1/3/17.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
