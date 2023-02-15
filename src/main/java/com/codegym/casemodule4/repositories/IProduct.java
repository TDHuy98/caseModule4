package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IProduct extends PagingAndSortingRepository<Product, Long> {

}