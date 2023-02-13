package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}