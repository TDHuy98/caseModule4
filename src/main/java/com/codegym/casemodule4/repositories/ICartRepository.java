package com.codegym.casemodule4.repositories;

import com.codegym.casemodule4.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository

public interface ICartRepository extends JpaRepository<Cart,Long>, JpaSpecificationExecutor<Cart>{
}