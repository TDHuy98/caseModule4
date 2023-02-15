package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    List<Product> findAllByCategoryId(int id);
    @Query(nativeQuery = true, value =
            "select * from product where productname like concat('%',:name,'%')")
    List<Product> search(@Param("name") String name);
}