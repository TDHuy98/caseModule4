package com.codegym.casemodule4.repositories;


import com.codegym.casemodule4.entities.Product;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepo extends PagingAndSortingRepository<Product, Integer> {
    @Query(nativeQuery = true, value =
            "select * from product where productname like concat('%',:name,'%')")
    List<Product> search(@Param("name") String name);
}
