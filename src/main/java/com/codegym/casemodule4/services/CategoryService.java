package com.codegym.casemodule4.services;

import com.codegym.casemodule4.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getCategoryList();

    void addCategory(Category category);

    void removeCategoryById(Integer id);

    Optional<Category> getCategoryById(Integer id);
}
