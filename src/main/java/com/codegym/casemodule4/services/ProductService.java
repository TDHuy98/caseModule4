package com.codegym.casemodule4.services;

import com.codegym.casemodule4.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getProductsList();

    void createProduct(Product product);

    void removeProductById(Long id);

    Optional<Product> getProductById(Long id);

    List<Product> getAllProductByCategoryId(int id);
}
