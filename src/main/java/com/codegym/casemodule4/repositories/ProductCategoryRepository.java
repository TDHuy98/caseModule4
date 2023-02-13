package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}