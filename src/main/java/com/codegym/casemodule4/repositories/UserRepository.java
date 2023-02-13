package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}